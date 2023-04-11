package com.domo.api.test

/**
 * @author domo
 * Created on 2023/04/07
 */
class TestDto {
    data class UserInfoDto(
        val userKey: String,
        val userRegistrationNumber: String,
        val userName: String,
        val userIncomeAmount: Long,
    )
}