package com.turnkeyafrica.crm.app.api.currency

import com.turnkeyafrica.crm.core.entities.Currency
import java.math.BigDecimal
import java.time.LocalDateTime

data class CurrencyDto (
        val code: Long?,
        val symbol: String,
        val desc: String,
        val round: BigDecimal,
        val exchangeRate: BigDecimal,
        val createdAt: LocalDateTime,
        val updatedAt: LocalDateTime
)

fun CurrencyDto.toCurrency() = Currency (
        code = code,
        symbol = symbol,
        desc = desc,
        round = round,
        exchangeRate = exchangeRate,
        createdAt = createdAt,
        updatedAt = updatedAt
)

fun Currency.toCurrencyDto() = CurrencyDto (
        code = code,
        symbol = symbol,
        desc = desc,
        round = round,
        exchangeRate = exchangeRate,
        createdAt = createdAt,
        updatedAt = updatedAt
)