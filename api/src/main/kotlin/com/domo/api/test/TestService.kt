package com.domo.api.test

import com.domo.domain.domain.UserInfo
import com.domo.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

/**
 * @author domo
 * Created on 2023/04/07
 */
@Service
class TestService(
    private val userInfoRepository: UserInfoRepository
) {

    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey).toDto()

    fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistrationNumber, userName, userIncomeAmount)
}