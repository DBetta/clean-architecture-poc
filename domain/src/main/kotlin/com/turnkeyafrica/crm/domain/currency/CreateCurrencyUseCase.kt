package com.turnkeyafrica.crm.domain.currency

import com.turnkeyafrica.crm.core.entities.Currency
import com.turnkeyafrica.crm.domain.UseCase

class CreateCurrencyUseCase(private val currencyRepository: CurrencyRepository): UseCase<Currency, Currency> {
    override suspend fun execute(request: Currency): Currency = currencyRepository.saveCurrency(currency = request)

    interface CurrencyRepository {
        suspend fun saveCurrency(currency: Currency): Currency
    }
}