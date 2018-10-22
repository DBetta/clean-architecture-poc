package com.turnkeyafrica.crm.data

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

fun com.turnkeyafrica.crm.core.page.PageRequest.toJpaPageRequest() = PageRequest.of(  this.getPageNumber(), this.getPageSize())

fun <T> Page<T>.fromJpaPage() =
        com.turnkeyafrica.crm.core.page.PageImpl(_content = this.content,
                _pageable = this.pageable.fromJpaPageRequest(),
                _total = this.totalElements)

private fun Pageable.fromJpaPageRequest(): com.turnkeyafrica.crm.core.page.Pageable {
    return com.turnkeyafrica.crm.core.page.PageRequest.of(this.pageNumber, this.pageSize)
}
