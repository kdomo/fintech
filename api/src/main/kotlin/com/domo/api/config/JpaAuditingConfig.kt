package com.domo.api.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * @author domo
 * Created on 2023/04/20
 */
@Configuration
@EnableJpaRepositories(basePackages = ["com.domo.domain"])
class JpaAuditingConfig {
}