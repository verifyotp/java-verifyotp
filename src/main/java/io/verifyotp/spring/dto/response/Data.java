package io.verifyotp.spring.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.verifyotp.spring.enums.Channel;

public class Data {
	private Channel channel;
	private String recipient;
	private String reference;
	private String otp;
	private int attempts;

	@JsonProperty("expires_at")
	private String expiresAt;

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

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

	public String getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}
}
