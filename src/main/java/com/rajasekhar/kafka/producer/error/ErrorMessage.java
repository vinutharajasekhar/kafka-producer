package com.rajasekhar.kafka.producer.error;

import java.time.LocalDateTime;

public class ErrorMessage {
    private LocalDateTime errorTimestamp;
    private String errorMessage;
    private String details;

    public ErrorMessage() {
    }

    public ErrorMessage(LocalDateTime errorTimestamp, String errorMessage, String details) {
        this.errorTimestamp = errorTimestamp;
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public LocalDateTime getErrorTimestamp() {
        return errorTimestamp;
    }

    public void setErrorTimestamp(LocalDateTime errorTimestamp) {
        this.errorTimestamp = errorTimestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
