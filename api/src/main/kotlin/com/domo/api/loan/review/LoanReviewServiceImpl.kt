package com.domo.api.loan.review

import com.domo.api.exception.CustomErrorCode
import com.domo.api.exception.CustomException
import com.domo.domain.domain.LoanReview
import com.domo.domain.repository.LoanReviewRepository
import org.springframework.stereotype.Service

/**
 * @author domo
 * Created on 2023/04/19
 */
@Service
class LoanReviewServiceImpl(
    private val loanReviewRepository: LoanReviewRepository
): LoanReviewService {
    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto {
        return LoanReviewDto.LoanReviewResponseDto(
            userKey = userKey,
            loanResult = getLoanResult(userKey)?.toResponseDto()
                ?: throw CustomException(CustomErrorCode.RESULT_NOT_FOUND)
        )
    }

    override fun getLoanResult(userKey: String) =
        loanReviewRepository.findByUserKey(userKey)

    private fun LoanReview.toResponseDto() =
        LoanReviewDto.LoanResult(
            userLimitAmount = this.loanLimitedAmount,
            userLoanInterest = this.loanInterest
        )
}