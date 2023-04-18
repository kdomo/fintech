package com.domo.api.loan.request

import com.domo.api.loan.GenerateKey
import com.domo.api.loan.encrypt.EncryptComponent
import com.domo.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

/**
 * @author domo
 * Created on 2023/04/18
 */
@Service
class LoanRequestServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent
): LoanRequestService {

    override fun loanRequestMain(loanRequestInputDto: LoanRequestDto.LoanRequestInputDto): LoanRequestDto.LoanRequestResponseDto {
        var userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber = encryptComponent.encryptString(
            loanRequestInputDto.userRegistrationNumber
        )
        saveUserInfo(
            loanRequestInputDto.toUserInfoDto(userKey)
        )
        loanRequestReview(userKey)

        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        userInfoRepository.save(userInfoDto.toEntity())


    override fun loanRequestReview(userKey: String) {
        TODO("Not yet implemented")
    }

}