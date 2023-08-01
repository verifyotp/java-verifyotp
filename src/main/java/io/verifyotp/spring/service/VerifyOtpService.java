package io.verifyotp.spring.service;

import io.verifyotp.spring.dto.request.CreateOtpRequest;
import io.verifyotp.spring.dto.request.VerifyOtpRequest;
import io.verifyotp.spring.dto.response.CreateOtpResponse;
import io.verifyotp.spring.dto.response.VerifyOtpResponse;

public interface VerifyOtpService {

    CreateOtpResponse createOtp(CreateOtpRequest createOtpRequest);

    VerifyOtpResponse verifyOtp(VerifyOtpRequest verifyOtpRequest);
}
