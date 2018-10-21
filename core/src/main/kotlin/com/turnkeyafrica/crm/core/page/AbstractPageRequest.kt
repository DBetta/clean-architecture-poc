package com.turnkeyafrica.crm.core.page

import java.io.Serializable
import java.lang.IllegalArgumentException

/**
 * Abstract implementation of [Pageable]
 *
 * @author Denis Gitonga
 */
abstract class AbstractPageRequest: Pageable, Serializable {

    private var page: Int
    private var size: Int

    private constructor(): this(0, 10)


    /**
     * Creates a new [AbstractPageRequest]. Pages are zero indexed, thus providing 0 for [page] will return
     * the first page.
     *
     * @param page must not be less than zero.
     * @param size must not be less than one
     */
    constructor(
             page: Int,
             size: Int
    ) {
        if (page < 0)
            throw IllegalArgumentException("Page index must not be less than zero")
        if (size < 1)
            throw IllegalArgumentException("Page size must not be less than one!")

        this.page = page
        this.size = size
    }

    /**
     * @see Pageable.getPageSize()
     */
    override fun getPageSize(): Int = size


    /**
     * @see Pageable.getPageNumber()
     */
    override fun getPageNumber() = page

    /**
     * @see Pageable.getOffset()
     */
    override fun getOffset(): Int {
        return page * size
    }

    /**
     * @see Pageable.hasPrevious()
     */
    override fun hasPrevious(): Boolean {
        return page > 0
    }

    /**
     * @see Pageable.previousOrFirst()
     */
    override fun previousOrFirst(): Pageable {
        return if (hasPrevious()) previous() else first()
    }

    /**
     * @see Pageable.next()
     */
    abstract override fun next(): Pageable

    /**
     * Returns the [Pageable] requesting the previous [Page]
     *
     * @return
     */
    abstract fun previous(): Pageable

    /**
     * @see Pageable.first()
     */
    abstract override fun first(): Pageable

    /**
     * @see Any.hashCode()
     */
    override fun hashCode(): Int {
        val prime = 31L
        var result = 1L

        result = prime * result + page
        result = prime * result + size

        return result.toInt()
    }

    /**
	 *
	 * @see Any.equals(Any)
	 */
    override fun equals(other: Any?): Boolean {

        if (this === other) {
            return true
        }

        if (other == null || javaClass != other.javaClass) {
            return false
        }

        val obj = other as AbstractPageRequest?
        return this.page == obj!!.page && this.size == obj.size
    }
}