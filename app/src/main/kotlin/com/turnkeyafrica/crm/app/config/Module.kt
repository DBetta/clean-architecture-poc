package com.turnkeyafrica.crm.app.config

import com.turnkeyafrica.crm.data.repositories.DBCurrencyRepository
import com.turnkeyafrica.crm.data.repositories.JpaCurrencyRepository
import com.turnkeyafrica.crm.domain.UseCaseExecutorImp
import com.turnkeyafrica.crm.domain.currency.CreateCurrencyUseCase
import com.turnkeyafrica.crm.domain.currency.GetCurrenciesUseCase
import com.turnkeyafrica.crm.domain.gateway.CurrencyRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Module {

    @Bean
    fun useCaseExecutor() = UseCaseExecutorImp()

    @Bean
    fun getCurrenciesUseCase(currencyRepository: CurrencyRepository) = GetCurrenciesUseCase(currencyRepository)

    @Bean
    fun createCurrencyUseCase(currencyRepository: CurrencyRepository) = CreateCurrencyUseCase(currencyRepository)

    @Bean
    fun currencyRepository(dbCurrencyRepository: DBCurrencyRepository) = JpaCurrencyRepository(dbCurrencyRepository)
}