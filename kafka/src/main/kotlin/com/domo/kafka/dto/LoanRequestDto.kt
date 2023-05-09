package com.domo.kafka.dto

/**
 * @author domo
 * Created on 2023/04/25
 */
data class LoanRequestDto(
    val userKey: String,
    val userName: String,
    val userIncomeAmount: Long,
    val userRegistrationNumber: String
) {
}