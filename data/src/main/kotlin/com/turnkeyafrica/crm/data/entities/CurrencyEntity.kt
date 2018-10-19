package com.turnkeyafrica.crm.data.entities

import com.turnkeyafrica.crm.core.entities.Currency
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tqc_currencies")
data class CurrencyEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "cur_code")
        val code: Long?,
        @Column(name = "cur_symbol")
        val symbol: String,
        @Column(name = "cur_desc")
        val desc: String,
        @Column(name = "cur_rnd")
        val round: BigDecimal,
        @Column(name = "cur_exchange_rate")
        val exchangeRate: BigDecimal,
        @Column(name = "cur_updated_at")
        val createdAt: LocalDateTime,
        @Column(name = "cur_created_at")
        val updatedAt: LocalDateTime
)

fun CurrencyEntity.toCurrency() = Currency(
        code = code,
        symbol = symbol,
        desc = desc,
        round = round,
        exchangeRate = exchangeRate,
        createdAt = createdAt,
        updatedAt = updatedAt
)

fun Currency.toCurrencyEntity() = CurrencyEntity (
        code = code,
        symbol = symbol,
        desc = desc,
        round = round,
        exchangeRate = exchangeRate,
        createdAt = createdAt,
        updatedAt = updatedAt
)