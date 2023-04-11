package com.domo.domain.repository

import com.domo.domain.domain.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author domo
 * Created on 2023/04/07
 */
interface UserInfoRepository : JpaRepository<UserInfo, Long> {
    fun findByUserKey(userKey: String): UserInfo
}