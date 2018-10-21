package com.turnkeyafrica.crm.data.entities

import com.turnkeyafrica.crm.core.entities.Currency
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tqc_currencies")
data class CurrencyEntity(
        @Id
        @Column(name = "cur_code")
        val code: String,
        @Column(name = "cur_symbol")
        val symbol: String,
        @Column(name = "cur_name")
        val name: String,
        @Column(name = "cur_updated_at")
        val createdAt: LocalDateTime,
        @Column(name = "cur_created_at")
        val updatedAt: LocalDateTime
)

fun CurrencyEntity.toCurrency() = Currency(
        code = code,
        symbol = symbol,
        name = name,
        createdAt = createdAt,
        updatedAt = updatedAt
)

fun Currency.toCurrencyEntity() = CurrencyEntity (
        code = code,
        symbol = symbol,
        name = name,
        createdAt = createdAt,
        updatedAt = updatedAt
)