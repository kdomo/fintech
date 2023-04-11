package com.domo.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * @author domo
 * Created on 2023/04/07
 */
@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.domo.domain"])
@EntityScan(basePackages = ["com.domo.domain"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}