package com.domo.api.loan.request

import com.domo.domain.domain.UserInfo

/**
 * @author domo
 * Created on 2023/04/18
 */
interface LoanRequestService {
    fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto

    fun saveUserInfo(
        userInfoDto: UserInfoDto
    ): UserInfo

    fun loanRequestReview(userKey: String)
}