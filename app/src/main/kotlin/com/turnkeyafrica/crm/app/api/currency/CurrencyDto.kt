package com.turnkeyafrica.crm.app.api.currency

import com.turnkeyafrica.crm.core.entities.Currency
import java.math.BigDecimal
import java.time.LocalDateTime

data class CurrencyDto (
        val code: String,
        val symbol: String,
        val name: String,
        val createdAt: LocalDateTime,
        val updatedAt: LocalDateTime
)

fun CurrencyDto.toCurrency() = Currency (
        code = code,
        symbol = symbol,
        name = name,
        createdAt = createdAt,
        updatedAt = updatedAt
)

fun Currency.toCurrencyDto() = CurrencyDto (
        code = code,
        symbol = symbol,
        name = name,
        createdAt = createdAt,
        updatedAt = updatedAt
)