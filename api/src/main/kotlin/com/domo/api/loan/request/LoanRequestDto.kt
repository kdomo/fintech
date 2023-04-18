package com.domo.api.loan.request

/**
 * @author domo
 * Created on 2023/04/18
 */
class LoanRequestDto {
    data class LoanRequestInputDto(
        val userName: String,
        val userIncomeAmount: Long,
        var userRegistrationNumber: String
    ) {
        fun toUserInfoDto(userKey: String) =
            UserInfoDto(
                userKey, userName, userRegistrationNumber, userIncomeAmount
            )
    }

    data class LoanRequestResponseDto(
        val userKey: String
    )
}