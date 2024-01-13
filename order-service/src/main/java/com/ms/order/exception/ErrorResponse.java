package com.ms.order.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonPropertyOrder({"timestamp", "errorCode", "errorMessage"})
public class ErrorResponse {
    private String errorMessage;
    private Integer errorCode;
    private LocalDateTime timestamp;
}
