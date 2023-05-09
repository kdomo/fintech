package com.domo.kafka.producer

import com.domo.kafka.dto.LoanRequestDto
import com.domo.kafka.enum.KafkaTopic
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

/**
 * @author domo
 * Created on 2023/04/25
 */
@Component
class LoanRequestSender(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {
    fun sendMessage(topic: KafkaTopic, loanRequestDto: LoanRequestDto) {
        kafkaTemplate.send(topic.topicName, objectMapper.writeValueAsString(loanRequestDto))
    }
}