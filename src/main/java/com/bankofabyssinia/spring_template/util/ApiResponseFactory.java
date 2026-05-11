package com.bankofabyssinia.spring_template.util;

import java.time.OffsetDateTime;

import com.bankofabyssinia.spring_template.dto.Response.ApiResponse;

public final class ApiResponseFactory {

    private ApiResponseFactory() {
    }

    public static <T> ApiResponse<T> success(String message, T data, String path) {
        return new ApiResponse<>(200, true, OffsetDateTime.now().toString(), path, message, data);
    }

    public static ApiResponse<Void> success(String message, String path) {
        return new ApiResponse<>(200, true, OffsetDateTime.now().toString(), path, message, null);
    }

    public static <T> ApiResponse<T> failure(String message, String path) {
        return new ApiResponse<>(400, false, OffsetDateTime.now().toString(), path, message, null);
    }
}
