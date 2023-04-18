package com.domo.api.loan

import org.springframework.stereotype.Component
import java.util.*

/**
 * @author domo
 * Created on 2023/04/18
 */
@Component
class GenerateKey {
    fun generateUserKey() = UUID.randomUUID().toString().replace("-", "");
}