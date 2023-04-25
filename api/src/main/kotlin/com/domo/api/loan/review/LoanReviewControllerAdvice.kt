package com.domo.api.loan.review

import com.domo.api.exception.CustomException
import com.domo.api.exception.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @author domo
 * Created on 2023/04/25
 */
@RestControllerAdvice(basePackageClasses = [LoanReviewController::class])
class LoanReviewControllerAdvice {

    @ExceptionHandler(CustomException::class)
    fun customExceptionHandler(customException: CustomException) =
        ErrorResponse(customException).toResponseEntity()
}