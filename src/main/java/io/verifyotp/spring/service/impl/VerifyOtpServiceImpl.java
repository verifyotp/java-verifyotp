package io.verifyotp.spring.service.impl;

import io.verifyotp.spring.configuration.VerifyOtpProperties;
import io.verifyotp.spring.dto.request.CreateOtpRequest;
import io.verifyotp.spring.dto.request.VerifyOtpRequest;
import io.verifyotp.spring.dto.response.CreateOtpResponse;
import io.verifyotp.spring.dto.response.VerifyOtpResponse;
import io.verifyotp.spring.service.VerifyOtpService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;

public class VerifyOtpServiceImpl implements VerifyOtpService {

    private static final String VERIFYOTP_API_ENDPOINT = "https://api.verifyotp.io/api/v1/otp";
    private static final String VERIFYOTP_API_KEY_HEADER = "x-api-key";
    private static final int CONNECTION_TIME_OUT = 30;
    private static final int READ_TIME_OUT = 30;

    @Autowired private VerifyOtpProperties verifyOtpProperties;
    @Autowired private RestTemplateBuilder restTemplateBuilder;

    private RestTemplate restTemplate;

    @PostConstruct
    private void init() {
        if (!StringUtils.hasLength(verifyOtpProperties.getApiKey())) {
            throw new IllegalStateException("verifyotp API key required");
        }

        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(CONNECTION_TIME_OUT))
                .setReadTimeout(Duration.ofSeconds(READ_TIME_OUT))
                .build();
    }

    @Override
    public CreateOtpResponse createOtp(CreateOtpRequest createOtpRequest) {
        return sendOtp(createOtpRequest);
    }

    @Override
    public VerifyOtpResponse verifyOtp(VerifyOtpRequest verifyOtpRequest) {
        return validateOtp(verifyOtpRequest);
    }

    private CreateOtpResponse sendOtp(CreateOtpRequest createOtpRequest) {
        CreateOtpResponse response;

        try {
            HttpHeaders httpHeaders = populateHttpHeaders();
            HttpEntity<CreateOtpRequest> request = new HttpEntity<>(createOtpRequest, httpHeaders);
            response = restTemplate.postForObject(VERIFYOTP_API_ENDPOINT + "/send", request, CreateOtpResponse.class);
            return response;
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
            throw  new RuntimeException("error sending otp");
        }
    }

    private VerifyOtpResponse validateOtp(VerifyOtpRequest verifyOtpRequest) {
        VerifyOtpResponse response;

        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(VERIFYOTP_API_ENDPOINT + "/verify")
                    .queryParam("reference", verifyOtpRequest.getReference())
                    .queryParam("otp", verifyOtpRequest.getOtp());

            HttpHeaders httpHeaders = populateHttpHeaders();
            HttpEntity<VerifyOtpRequest> request = new HttpEntity<>(httpHeaders);
            response = restTemplate.getForObject(builder.toUriString(), VerifyOtpResponse.class, request);
            return response;
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
            throw  new RuntimeException("error validating otp");
        }
    }

    private HttpHeaders populateHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(VERIFYOTP_API_KEY_HEADER, verifyOtpProperties.getApiKey());
        httpHeaders.set("Content-Type", "application/json");
        return httpHeaders;
    }
}
