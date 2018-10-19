package com.turnkeyafrica.crm.data.repositories

import com.turnkeyafrica.crm.data.entities.CurrencyEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigDecimal

interface DBCurrencyRepository : JpaRepository<CurrencyEntity, BigDecimal>