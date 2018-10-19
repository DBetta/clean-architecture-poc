package com.turnkeyafrica.crm.data

import com.turnkeyafrica.crm.data.config.DBConfig
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [DBConfig::class])
class DataApplicationTests {

    @Test
    fun contextLoads() {
    }

}
