package com.domo.api.loan.review

/**
 * @author domo
 * Created on 2023/04/19
 */
class LoanReviewDto {
    data class LoanReviewResponseDto(
        val userKey: String,
        val loanResult: LoanResult
    )

    data class LoanResult(
        val userLimitAmount: Long,
        val userLoanInterest: Double
    )

    data class LoanReview(
        val userKey: String,
        val userLimitAmount: Long,
        val userLoanInterest: Double
    )
}