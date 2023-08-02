package io.verifyotp.spring.dto.request;

public class VerifyOtpRequest {
    private String reference;
    private String otp;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
