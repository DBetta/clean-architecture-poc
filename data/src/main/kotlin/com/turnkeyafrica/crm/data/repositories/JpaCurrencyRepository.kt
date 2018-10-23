package com.turnkeyafrica.crm.data.repositories

import com.turnkeyafrica.crm.core.entities.Currency
import com.turnkeyafrica.crm.core.page.Page
import com.turnkeyafrica.crm.core.page.PageRequest
import com.turnkeyafrica.crm.data.entities.toCurrency
import com.turnkeyafrica.crm.data.entities.toCurrencyEntity
import com.turnkeyafrica.crm.data.fromJpaPage
import com.turnkeyafrica.crm.data.toJpaPageRequest
import com.turnkeyafrica.crm.domain.gateway.CurrencyRepository

class JpaCurrencyRepository(private val dbCurrencyRepository: DBCurrencyRepository) : CurrencyRepository {
    override suspend fun getCurrencies(pageRequest: PageRequest): Page<Currency> {
        return dbCurrencyRepository.findAll(pageRequest.toJpaPageRequest())
                .fromJpaPage()
                .map { it.toCurrency() }
    }

    override suspend fun saveCurrency(currency: Currency): Currency {
        val currencyEntity = dbCurrencyRepository.save(currency.toCurrencyEntity())

        return currencyEntity.toCurrency()
    }

    override suspend fun getCurrencies(): List<Currency> = dbCurrencyRepository.findAll()
            .map { it.toCurrency() }
}