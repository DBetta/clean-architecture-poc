package com.turnkeyafrica.crm.app.api.currency

import com.turnkeyafrica.crm.core.page.Page
import com.turnkeyafrica.crm.core.page.PageRequest
import java.util.concurrent.CompletionStage

interface CurrencyResource {

    fun getCurrencies(page: Int, size: Int): CompletionStage<Page<CurrencyDto>>

    fun saveCurrency(currencyDto: CurrencyDto): CompletionStage<CurrencyDto>
}