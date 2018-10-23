package com.turnkeyafrica.crm.app.api.currency

import com.turnkeyafrica.crm.core.page.Page
import com.turnkeyafrica.crm.core.page.PageRequest
import com.turnkeyafrica.crm.domain.UseCaseExecutor
import com.turnkeyafrica.crm.domain.currency.CreateCurrencyUseCase
import com.turnkeyafrica.crm.domain.currency.GetCurrenciesUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import kotlinx.coroutines.launch
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
    override fun getCurrencies(page: Int, size: Int): CompletionStage<Page<CurrencyDto>> {

        GlobalScope.launch {
            var currentPage = page - 1
            do {

                val currencyDto = useCaseExecutor(
                        useCase = getCurrenciesUseCase,
                        requestDto = PageRequest.of(page = ++currentPage, size = size),
                        requestConverter = { it },
                        responseConverter = { currencies -> currencies.map { it.toCurrencyDto() } }
                )

                currencyDto.forEach { println(it) }
            }while (currencyDto.hasNext())



        }

        return GlobalScope.future {
            useCaseExecutor(
                    useCase = getCurrenciesUseCase,
                    requestDto = PageRequest.of(page = page, size = size),
                    requestConverter = { it },
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