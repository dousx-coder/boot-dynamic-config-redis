package io.github.dousxcoder.dcredis;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * DcredisAutoConfigure
 */
@AutoConfiguration
@Import({DcredisConfiguration.class})
public class DcredisAutoConfigure {
}
