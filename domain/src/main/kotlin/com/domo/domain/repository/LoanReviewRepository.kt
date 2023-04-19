package com.domo.domain.repository

import com.domo.domain.domain.LoanReview
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author domo
 * Created on 2023/04/07
 */
interface LoanReviewRepository : JpaRepository<LoanReview, Long> {
    fun findByUserKey(userKey: String): LoanReview
}