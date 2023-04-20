package com.domo.api.loan.request

import com.domo.api.loan.GenerateKey
import com.domo.api.loan.encrypt.EncryptComponent
import com.domo.domain.repository.UserInfoRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.setup.MockMvcBuilders

/**
 * @author domo
 * Created on 2023/04/20
 */
@WebMvcTest(LoanRequestController::class)
internal class LoanRequestControllerTest {

    private lateinit var mockMvc: MockMvc

    private lateinit var loanRequestController: LoanRequestController

    private lateinit var generateKey: GenerateKey

    private lateinit var encryptComponent: EncryptComponent

    private val userInfoRepository: UserInfoRepository = mockk()

    private lateinit var mapper: ObjectMapper

    @MockBean
    private lateinit var loanRequestService: LoanRequestService

    companion object {
        private const val baseUrl = "/fintech/api/v1"
    }


    @BeforeEach
    fun setUp() {
        generateKey = GenerateKey()

        encryptComponent = EncryptComponent()

        loanRequestService = LoanRequestServiceImpl(
            generateKey, userInfoRepository, encryptComponent
        )

        loanRequestController = LoanRequestController(loanRequestService)

        mockMvc = MockMvcBuilders.standaloneSetup(loanRequestController).build()

        mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
    }

    @Test
    @DisplayName("유저 요청이 들어오면 정상 응답을 주어야 한다.")
    fun testNormalCase() {
        // given
        val loanRequestInputDto = LoanRequestDto.LoanRequestInputDto(
            userName = "TEST",
            userIncomeAmount = 1000000,
            userRegistrationNumber = "123456-1234567"
        )

        // when
        every { userInfoRepository.save(any()) } returns UserInfoDto(
            userKey = "domo",
            username = "TEST",
            userRegistrationNumber = "123456-1234567",
            userIncomeAmount = 1000000
        ).toEntity()

        // then
        mockMvc.post("$baseUrl/request") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(loanRequestInputDto)
        }.andExpect {
            status { isOk() }
        }
    }
}