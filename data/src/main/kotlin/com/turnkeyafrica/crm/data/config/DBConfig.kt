package com.turnkeyafrica.crm.data.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@Configuration
@EntityScan(basePackages = ["com.turnkeyafrica.crm.data"])
@EnableJpaRepositories(basePackages = ["com.turnkeyafrica.crm.data"])
class DBConfig