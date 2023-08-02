package io.verifyotp.spring.configuration;

import io.verifyotp.spring.service.VerifyOtpService;
import io.verifyotp.spring.service.impl.VerifyOtpServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(VerifyOtpProperties.class)
public class ApplicationConfig {

    @Bean
    public VerifyOtpService verifyOtpService() {
        return new VerifyOtpServiceImpl();
    }
}
