package com.sagar.microservices.order.response;

import com.sagar.microservices.order.enums.ResponseCode;
import org.springframework.http.ResponseEntity;

public class OrderServiceResponse {
    /**
     * Generates a standardized API response with a message, status, and data.
     *
     * @param responseCode It contains the message and HTTP status.
     * @param responseObj The data to be included in the response.
     * @return It contains the response data, status, and message.
     */
    public static ResponseEntity<ApiResponse> build(
            final ResponseCode responseCode,
            final Object responseObj) {
        ApiResponse apiResponse = new ApiResponse(
                responseCode.getCode(),
                responseCode.getMessage(),
                responseObj);
        return new ResponseEntity<>(apiResponse, responseCode.getHttpStatus());
    }
}
