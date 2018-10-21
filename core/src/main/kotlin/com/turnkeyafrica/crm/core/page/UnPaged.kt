package com.turnkeyafrica.crm.core.page

enum class UnPaged: Pageable {
    INSTANCE;

    /**
     * @see Pageable.isPaged()
     */
    override fun isPaged(): Boolean = false

    /**
     * @see Pageable.previousOrFirst()
     */
    override fun previousOrFirst() = this

    /**
     * @see Pageable.next()
     */
    override fun next() = this

    /**
     * @see Pageable.hasPrevious()
     */
    override fun hasPrevious() = false

    /**
     * @see Pageable.getPageSize()
     */
    override fun getPageSize() = throw UnsupportedOperationException()

    /**
     * @see Pageable.getPageNumber()
     */
    override fun getPageNumber() = throw UnsupportedOperationException()

    /**
     * @see Pageable.getOffset()
     */
    override fun getOffset(): Int {
        throw UnsupportedOperationException()
    }


    /**
     * @see Pageable.first()
     */
    override fun first(): Pageable {
        return this
    }

}