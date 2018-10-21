package com.turnkeyafrica.crm.core.entities

import java.math.BigDecimal
import java.time.LocalDateTime

data class Currency(
        val code: String,
        val symbol: String,
        val name: String,
        val createdAt: LocalDateTime,
        val updatedAt: LocalDateTime
)