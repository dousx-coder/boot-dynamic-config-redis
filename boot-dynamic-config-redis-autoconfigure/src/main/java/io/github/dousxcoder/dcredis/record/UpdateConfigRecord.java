package io.github.dousxcoder.dcredis.record;

import io.github.dousxcoder.dcredis.annotation.DcredisProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 更新配置参数
 *
 * @param key    {@link DcredisProperty#key()}
 * @param config 配置
 */
public record UpdateConfigRecord(String key, Object config) implements Serializable {
    /**
     * 更新配置
     *
     * @param key    key
     * @param config config
     */
    public UpdateConfigRecord {
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("annotationKey is blank");
        }
    }

    /**
     * 获取配置key
     *
     * @return key
     */
    @Override
    public String key() {
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("annotationKey is blank");
        }
        return key;
    }

    /**
     * 获取配置
     *
     * @return config
     */
    @Override
    public Object config() {
        return config;
    }
}
