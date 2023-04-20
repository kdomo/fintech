package com.domo.api.aop

import mu.KotlinLogging
import org.aopalliance.intercept.Joinpoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch
import kotlin.math.log

/**
 * @author domo
 * Created on 2023/04/20
 */
@Aspect
@Component
class LogAspect {
    val logger = KotlinLogging.logger { }

    @Pointcut("within(com.domo.api..*)")
    private fun isApi() {
    }

    @Around("isApi()")
    fun loggingAspect(joinpoint: ProceedingJoinPoint): Any {
        val stopWatch = StopWatch()
        stopWatch.start()

        val result = joinpoint.proceed()

        stopWatch.stop()

        logger.info { "${joinpoint.signature.name} ${joinpoint.args[0]} ${stopWatch.lastTaskTimeMillis}" }

        return result
    }
}