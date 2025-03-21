package io.github.dousxcoder.dcredis.annotation;


import java.lang.annotation.*;

/**
 * 配置属性
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DcredisProperty {
    /**
     * The property name.
     *
     * @return property key
     */
    String key();

    /**
     * 默认值
     * <br/>
     * 这里为了方便，这里用字符串的方式配置，实际上redis和本地缓存中存的是{@link DcredisProperty}所标注方法的返回值类型，
     * 如果返回值为复杂对象类型，则ConfigInvocationHandler会将值转换成对应的类型
     *
     * @return 默认值
     */
    String defaultValue() default "";

}
