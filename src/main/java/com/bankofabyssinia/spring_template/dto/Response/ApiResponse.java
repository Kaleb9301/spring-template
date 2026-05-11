package com.bankofabyssinia.spring_template.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private int status;
    private boolean success;
    private String message;
    private String timeStamp;
    private T data;
    
}
