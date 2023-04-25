package com.domo.api.exception

import org.springframework.http.ResponseEntity
import java.time.LocalDateTime

/**
 * @author domo
 * Created on 2023/04/25
 */
class ErrorResponse(
    private val customException: CustomException
){
    fun toResponseEntity(): ResponseEntity<ErrorResponseDto> {
        return ResponseEntity
            .status(customException.customErrorCode.statusCode)
            .body(
                ErrorResponseDto(
                    customException.customErrorCode.errorCode,
                    customException.customErrorCode.errorMessage
                )
            )
    }

    data class ErrorResponseDto(
        val errorCode: String,
        val errorMessage: String
    ) {
        val timeStamp = LocalDateTime.now()
    }
}