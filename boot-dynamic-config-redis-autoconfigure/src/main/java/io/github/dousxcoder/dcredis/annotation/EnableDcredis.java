package io.github.dousxcoder.dcredis.annotation;

import io.github.dousxcoder.dcredis.DcredisConfiguration;
import io.github.dousxcoder.dcredis.registry.ImportDcredisProxyRegistrar;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启配置，并指定扫描的包名
 * <br>
 * 使用了@Import注解,取代从/META-INF/spring.factories加载配置
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfiguration
@Import({ImportDcredisProxyRegistrar.class, DcredisConfiguration.class})
public @interface EnableDcredis {
    /**
     * 需要扫描的包
     * <br/>
     * 默认是当前包及子包
     *
     * @return 需要扫描的包
     */
    String[] basePackages() default {};
}