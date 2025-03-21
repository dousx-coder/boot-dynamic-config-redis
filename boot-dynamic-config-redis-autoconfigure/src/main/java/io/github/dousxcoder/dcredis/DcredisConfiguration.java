package io.github.dousxcoder.dcredis;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * DcredisConfiguration
 */
@Configuration
@ComponentScan
@ConfigurationPropertiesScan
@EnableConfigurationProperties
public class DcredisConfiguration {
}
