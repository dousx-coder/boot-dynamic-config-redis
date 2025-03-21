package io.github.dousxcoder.dcredis.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * dcredis配置
 */
@Configuration
@ConfigurationProperties(prefix = "dcredis.config")
public class DcredisProperties {

    /**
     * 配置命名空间
     * <br/>
     * 不可为空
     * <br/>
     * 多个项目共用同一个redis时，用nameSpace隔离配置
     */
    private String nameSpace;

    /**
     * 获取命名空间
     *
     * @return nameSpace
     */
    public String getNameSpace() {
        return nameSpace;
    }

    /**
     * @param nameSpace nameSpace
     */
    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }
}
