package com.bankofabyssinia.spring_template.dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenValidationResponse {
    @JsonProperty("isValid")
    private boolean valid;
    private String accessToken;
}
