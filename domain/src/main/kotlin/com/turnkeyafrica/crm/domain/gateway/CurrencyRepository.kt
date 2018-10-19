package com.turnkeyafrica.crm.domain.gateway

import com.turnkeyafrica.crm.domain.currency.CreateCurrencyUseCase
import com.turnkeyafrica.crm.domain.currency.GetCurrenciesUseCase

interface CurrencyRepository : GetCurrenciesUseCase.CurrencyRepository, CreateCurrencyUseCase.CurrencyRepository