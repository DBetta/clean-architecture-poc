package com.turnkeyafrica.crm.app

import com.turnkeyafrica.crm.domain.UseCase
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [
    "com.turnkeyafrica.crm.app",
    "com.turnkeyafrica.crm.data"
])
class AppApplication

fun main(args: Array<String>) {
    runApplication<AppApplication>(*args)
}

class TestUseCase : UseCase<String, String> {
    override fun execute(request: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
