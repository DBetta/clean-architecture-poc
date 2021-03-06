package com.turnkeyafrica.crm.domain.currency

import com.turnkeyafrica.crm.core.entities.Currency
import com.turnkeyafrica.crm.core.page.Page
import com.turnkeyafrica.crm.core.page.PageRequest
import com.turnkeyafrica.crm.domain.UseCase

class GetCurrenciesUseCase(private val currencyRepository: CurrencyRepository) : UseCase<PageRequest, Page<Currency>> {


    override suspend fun execute(request: PageRequest): Page<Currency> = currencyRepository.getCurrencies(pageRequest = request)

    interface CurrencyRepository {
        suspend fun getCurrencies(): List<Currency>

        suspend fun getCurrencies(pageRequest: PageRequest): Page<Currency>
    }
}