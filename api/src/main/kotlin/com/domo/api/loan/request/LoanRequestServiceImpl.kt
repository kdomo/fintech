package com.domo.api.loan.request

import com.domo.api.loan.GenerateKey
import com.domo.api.loan.encrypt.EncryptComponent
import com.domo.domain.repository.UserInfoRepository
import com.domo.kafka.enum.KafkaTopic
import com.domo.kafka.producer.LoanRequestSender
import org.springframework.stereotype.Service

/**
 * @author domo
 * Created on 2023/04/18
 */
@Service
class LoanRequestServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent,
    private val loanRequestSender: LoanRequestSender
): LoanRequestService {

    override fun loanRequestMain(loanRequestInputDto: LoanRequestDto.LoanRequestInputDto): LoanRequestDto.LoanRequestResponseDto {
        var userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber =
            encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        val userInfoDto = loanRequestInputDto.toUserInfoDto(userKey)

        saveUserInfo(userInfoDto)
        loanRequestReview(userInfoDto)

        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        userInfoRepository.save(userInfoDto.toEntity())


    override fun loanRequestReview(userInfoDto: UserInfoDto) {
        loanRequestSender.sendMessage(
            KafkaTopic.LOAN_REQUEST,
            userInfoDto.toLoanRequestKafkaDto()
        )
    }

}