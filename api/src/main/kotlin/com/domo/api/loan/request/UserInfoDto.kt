package com.domo.api.loan.request

import com.domo.domain.domain.UserInfo

/**
 * @author domo
 * Created on 2023/04/18
 */
data class UserInfoDto(
    val userKey: String,
    val username: String,
    val userRegistrationNumber: String,
    val userIncomeAmount: Long
) {
    fun toEntity(): UserInfo =
        UserInfo(
            userKey, userRegistrationNumber, username, userIncomeAmount
        )

}