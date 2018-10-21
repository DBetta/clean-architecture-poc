package com.turnkeyafrica.crm.core.page

/**
 * Base implementation of [Pageable]
 */
class PageRequest private constructor(page: Int, size: Int)
    : AbstractPageRequest(page, size) {

    /**
     * @see Pageable.next()
     */
    override fun next(): Pageable =
            PageRequest(getPageNumber()+1, getPageSize())


    /**
     * @see AbstractPageRequest.previous()
     */
    override fun previous(): Pageable {
       return if (getPageNumber() == 0) this else PageRequest(page = getPageNumber() - 1, size = getPageSize())
    }

    /**
     * @see Pageable.first()
     */
    override fun first(): Pageable {
        return PageRequest(page = 0, size = getPageSize())
    }

    /**
     * @see Any.equals(Any)
     */
    override fun equals(other: Any?): Boolean {

        if (this === other) return true

        if (!(other is PageRequest)) return false

        return super.equals(other)
    }

    /**
     * @see Any.hashCode()
     */
    override fun hashCode(): Int {
        return 31 * super.hashCode()
    }

    companion object {
        /**
         * Creates new unsorted [PageRequest]
         *
         * @param page zero-based page index
         * @param size the size of the page to be returned
         */
        fun of(page: Int, size: Int): PageRequest =
                PageRequest(page = page, size = size)
    }
}