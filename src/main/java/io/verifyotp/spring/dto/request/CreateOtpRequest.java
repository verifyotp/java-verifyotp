package io.verifyotp.spring.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.verifyotp.spring.enums.Channel;
import org.springframework.lang.NonNull;

public class CreateOtpRequest {

    @NonNull private String recipient;
    @NonNull private Channel channel;
    private int length;
    private int expiry;
    private int attempts;

    @JsonProperty("template_id")
    private String templateId;

    @NonNull
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(@NonNull String recipient) {
        this.recipient = recipient;
    }

    @NonNull
    public Channel getChannel() {
        return channel;
    }

    public void setChannel(@NonNull Channel channel) {
        this.channel = channel;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
