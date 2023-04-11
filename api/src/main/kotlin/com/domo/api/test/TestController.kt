package com.domo.api.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author domo
 * Created on 2023/04/07
 */
@RestController
@RequestMapping("/fintech/api/v1")
class TestController(
    private val testService: TestService
) {

    @GetMapping("/test/get/{userKey}")
    fun test(@PathVariable userKey: String): TestDto.UserInfoDto = testService.testGetService(userKey)
}