package io.verifyotp.spring.annotation;

import io.verifyotp.spring.configuration.ApplicationConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({ApplicationConfig.class})
public @interface EnableVerifyOtp {
}
