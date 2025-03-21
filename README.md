## 使用

1. 引入依赖
- gradle
```groovy
    implementation 'io.github.dousx-coder:boot-dynamic-config-redis-starter:1.1.20250321-22'
```
- maven
```xml
    <dependency>
        <groupId>io.github.dousx-coder</groupId>
        <artifactId>boot-dynamic-config-redis-starter</artifactId>
        <version>1.1.20250321-22</version>
    </dependency>
```

2. 配置文件中指定`dcredis.config.nameSpace`

```yaml
dcredis:
  config:
    nameSpace: service-b
```

3. 添加`@EnableDynamicConfig`注解

```java

@EnableDynamicConfig
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

4. 定义配置接口
- `@DynamicConfig`标记为配置类。
- `@DynamicConfigProperty`指定key(建议使用`:`将key隔开,在大部分redis可视化工具中，会通过`:`将key分割做成树形展示)。
示例如下：

```java
@DynamicConfig
public interface ReaderConfig {

    @DynamicConfigProperty(key = "reader:url", defaultValue = "localhost")
    String getReaderUrl();

    @DynamicConfigProperty(key = "reader:port", defaultValue = "6369")
    Integer getReaderPort();

    @DynamicConfigProperty(key = "reader:retry", defaultValue = "true")
    Boolean getReaderRetry();
}
```


```java
@DcredisConfig
public interface OptionConfig {
    @DcredisProperty(key = "option:color", defaultValue = """
            ["REA","BLACK","green"]
            """)
    List<String> colorList();
}
```

```java
@DcredisConfig
public interface SealConfig {
    @DcredisProperty(key = "seal:info", defaultValue = """
            {
              "height": 2.0,
              "id": "1",
              "width": 1.2
            }
            """)
    SealInfo getSealInfo();
}
```
