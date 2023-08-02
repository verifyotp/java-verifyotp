# java-verifyotp
Java SDK for verifyotp
Compatible with spring boot version `3x` and Java version `8+`

Following steps to setup verifyotp in your spring boot projects
1. Add the verifyotp dependency to your `pom.xml` file:
```xml
        <dependency>
            <groupId>io.verifyotp</groupId>
            <artifactId>verifyotp-spring-boot-starter</artifactId>
            <version>1.0.0</version>
        </dependency>
```

2. Add your API key in the `application.yml` file
```yaml
verify-otp:
  api-key: <API_KEY_HERE>
```

3. Enable the verifyotp sdk in the main spring boot file as shown below
```java
@EnableVerifyOtp
@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
```

If you have come this far, congratulations, you have setup the verifyotp SDK in your project.
Now to use it for sending and verifying otps.

First step is to inject the `VerifyOtpService` into your service classes, you can use constructors or
autowire the dependencies. After that you can do the following actions

#### Sending and Validating OTP
```java
private final VerifyOtpService verifyOtpService;

public void someMethod() {
        verifyOtpService.createOtp(createOtpRequest);
        verifyOtpService.verifyOtp(verifyOtpRequest);
}
```