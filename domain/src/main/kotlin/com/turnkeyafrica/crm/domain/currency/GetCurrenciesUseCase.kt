package com.turnkeyafrica.crm.domain.currency

import com.turnkeyafrica.crm.core.entities.Currency
import com.turnkeyafrica.crm.domain.UseCase

class GetCurrenciesUseCase (private val currencyRepository: CurrencyRepository) : UseCase<Unit, List<Currency>> {


    override fun execute(request: Unit): List<Currency> = currencyRepository.getCurrencies()

    interface CurrencyRepository {
        fun getCurrencies(): List<Currency>
    }
}