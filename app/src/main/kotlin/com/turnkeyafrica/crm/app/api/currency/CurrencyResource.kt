package com.turnkeyafrica.crm.app.api.currency

import java.util.concurrent.CompletionStage

interface CurrencyResource {
    fun getCurrencies(): CompletionStage<List<CurrencyDto>>

    fun saveCurrency(currencyDto: CurrencyDto): CompletionStage<CurrencyDto>
}