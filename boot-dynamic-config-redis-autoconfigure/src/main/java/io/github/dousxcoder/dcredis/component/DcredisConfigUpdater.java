package io.github.dousxcoder.dcredis.component;


import cn.hutool.core.util.ObjectUtil;
import io.github.dousxcoder.dcredis.constant.TopicConstant;
import io.github.dousxcoder.dcredis.record.UpdateConfigRecord;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 更新配置
 */
@Component
public class DcredisConfigUpdater {
    private static final Logger log = LoggerFactory.getLogger(DcredisConfigUpdater.class);

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private DcredisAuxiliary dcredisAuxiliary;

    /**
     * 更新redis中的配置，并发布消息
     *
     * @param param {@link UpdateConfigRecord}
     */
    public void updateRedisConfig(UpdateConfigRecord param) {
        String annotationKey = param.key();
        Object newConfig = param.config();
        if (ObjectUtil.hasEmpty(newConfig, annotationKey)) {
            throw new IllegalArgumentException(String.format("[%s] config is null", annotationKey));
        }
        RLock lock = dcredisAuxiliary.getDcredisLock();
        lock.lock();
        try {
            String redisKey = dcredisAuxiliary.getRedisConfigKey(annotationKey);
            redissonClient.getBucket(redisKey).set(newConfig);
            // 发布消息
            redissonClient.getTopic(TopicConstant.CONFIG_TOPIC).publish(redisKey);
            log.info("{}==>{}", redisKey, newConfig);
        } finally {
            lock.unlock();
        }
    }
}