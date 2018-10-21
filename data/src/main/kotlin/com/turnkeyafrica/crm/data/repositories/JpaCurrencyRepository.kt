package com.turnkeyafrica.crm.data.repositories

import com.turnkeyafrica.crm.core.entities.Currency
import com.turnkeyafrica.crm.data.entities.toCurrency
import com.turnkeyafrica.crm.data.entities.toCurrencyEntity
import com.turnkeyafrica.crm.domain.gateway.CurrencyRepository

class JpaCurrencyRepository(private val dbCurrencyRepository: DBCurrencyRepository) : CurrencyRepository {
    override suspend fun saveCurrency(currency: Currency): Currency {
        val currencyEntity = dbCurrencyRepository.save(currency.toCurrencyEntity())

        return currencyEntity.toCurrency()
    }

    override suspend fun getCurrencies(): List<Currency> = dbCurrencyRepository.findAll()
            .map { it.toCurrency() }
}