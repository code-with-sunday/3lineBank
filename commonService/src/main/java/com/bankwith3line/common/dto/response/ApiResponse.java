package com.bankwith3line.common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private String responseCode;
    private String message = "Successful";
    private T data;

    public ApiResponse(boolean success, String responseCode, String message, T data) {
        this.success = success;
        this.responseCode = responseCode;
        this.message = message;
        this.data = data;
    }
}