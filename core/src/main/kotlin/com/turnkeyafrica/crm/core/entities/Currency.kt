package com.turnkeyafrica.crm.core.entities

import java.math.BigDecimal
import java.time.LocalDateTime

data class Currency(
        val code: Long?,
        val symbol: String,
        val desc: String,
        val round: BigDecimal,
        val exchangeRate: BigDecimal,
        val createdAt: LocalDateTime,
        val updatedAt: LocalDateTime
)