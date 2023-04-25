package com.domo.api.exception

import org.springframework.http.HttpStatus

/**
 * @author domo
 * Created on 2023/04/25
 */
enum class CustomErrorCode(
    val statusCode: HttpStatus,
    val errorCode: String,
    val errorMessage: String
) {
    RESULT_NOT_FOUND(HttpStatus.BAD_REQUEST, "E001", "result not found")
}