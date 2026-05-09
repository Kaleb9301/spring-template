package com.bankofabyssinia.spring_template.dto.Request;

import lombok.Data;

@Data
public class LogOutDto {
    private String accessToken;
    private String refreshToken;
}
