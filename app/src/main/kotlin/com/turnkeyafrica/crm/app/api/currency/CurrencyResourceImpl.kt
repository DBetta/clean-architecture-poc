package com.turnkeyafrica.crm.app.api.currency

import com.turnkeyafrica.crm.domain.UseCaseExecutor
import com.turnkeyafrica.crm.domain.currency.CreateCurrencyUseCase
import com.turnkeyafrica.crm.domain.currency.GetCurrenciesUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping(path = ["api/currencies"])
class CurrencyResourceImpl(
        private val useCaseExecutor: UseCaseExecutor,
        private val getCurrenciesUseCase: GetCurrenciesUseCase,
        private val createCurrencyUseCase: CreateCurrencyUseCase

) : CurrencyResource {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    override fun getCurrencies(): CompletionStage<List<CurrencyDto>> {
        return GlobalScope.future {
            useCaseExecutor(
                    useCase = getCurrenciesUseCase,
                    responseConverter = { currencies -> currencies.map { it.toCurrencyDto() } }
            )
        }
    }


    @PostMapping(consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    override fun saveCurrency(@RequestBody currencyDto: CurrencyDto): CompletionStage<CurrencyDto> =
            GlobalScope.future {
                useCaseExecutor(
                        useCase = createCurrencyUseCase,
                        requestDto = currencyDto,
                        requestConverter = { it.toCurrency() },
                        responseConverter = { it.toCurrencyDto() }
                )
            }
}