package com.domo.api.loan.review

/**
 * @author domo
 * Created on 2023/04/19
 */
interface LoanReviewService {
    fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto

    fun getLoanResult(userKey: String): LoanReviewDto.LoanReview
}