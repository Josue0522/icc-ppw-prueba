package ec.edu.ups.icc.labevaluation.core.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponseDto(
    LocalDateTime timestamp,
    int status,
    String error,
    String code,
    String message,
    String path,
    Map<String, String> details
) {}
