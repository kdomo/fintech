package com.domo.domain.domain

import javax.persistence.*

/**
 * @author domo
 * Created on 2023/04/07
 */
@Entity
@Table(name = "LOAN_REVIEW")
class LoanReview(
    @Column(name = "usr_key")
    val userKey: String,

    @Column(name = "loan_lat_amt")
    val loanLimitedAmount: Long,

    @Column(name = "loan_inter")
    val loanInterest: Double
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}