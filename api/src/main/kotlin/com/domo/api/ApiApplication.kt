package com.domo.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

/**
 * @author domo
 * Created on 2023/04/07
 */
@SpringBootApplication
@EntityScan(basePackages = ["com.domo.domain"])
@ComponentScan(basePackages = ["com.domo"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}