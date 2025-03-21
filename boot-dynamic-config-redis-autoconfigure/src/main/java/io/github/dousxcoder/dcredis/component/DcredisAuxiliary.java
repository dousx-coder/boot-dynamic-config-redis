package io.github.dousxcoder.dcredis.component;


import io.github.dousxcoder.dcredis.annotation.DcredisProperty;
import io.github.dousxcoder.dcredis.properties.DcredisProperties;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DcredisAuxiliary
 */
@Component
public class DcredisAuxiliary {
    /**
     * 本地缓存
     */

    @Autowired
    private DcredisProperties dcredisProperties;

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 获取redis key
     *
     * @param annotationKey {@link DcredisProperty#key()}的值
     * @return redis key
     */
    public String getRedisConfigKey(String annotationKey) {
        String nameSpace = dcredisProperties.getNameSpace();
        if (StringUtils.isBlank(nameSpace)) {
            throw new IllegalArgumentException("nameSpace is blank");
        }
        return nameSpace + ":" + annotationKey;
    }

    /**
     * 获取配置锁
     *
     * @return 锁
     */
    public RLock getDcredisLock() {
        String key = "dcredis:lock:" + dcredisProperties.getNameSpace();
        return redissonClient.getLock(key);
    }
}
