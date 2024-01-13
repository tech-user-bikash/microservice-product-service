package com.ms.inventory.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    private String errorMessage;
    private Integer errorCode;
    private LocalDateTime timestamp;
}
