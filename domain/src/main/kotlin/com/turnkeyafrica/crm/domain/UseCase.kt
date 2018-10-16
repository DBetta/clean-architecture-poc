package com.turnkeyafrica.crm.domain

interface UseCase<in Request, out Response> {
    fun execute(request: Request): Response
}
