package io.verifyotp.spring.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
	private String channel;
	private String recipient;
	private String reference;
	private String otp;
	private int length;

	@JsonProperty("attempts_left")
	private int attemptsLeft;

	@JsonProperty("expires_at")
	private String expiresAt;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getAttemptsLeft() {
		return attemptsLeft;
	}

	public void setAttemptsLeft(int attemptsLeft) {
		this.attemptsLeft = attemptsLeft;
	}
}
