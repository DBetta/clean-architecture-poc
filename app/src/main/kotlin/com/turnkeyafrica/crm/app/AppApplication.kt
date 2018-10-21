package com.turnkeyafrica.crm.app

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
