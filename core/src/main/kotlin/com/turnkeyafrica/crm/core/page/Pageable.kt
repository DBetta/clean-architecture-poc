package com.turnkeyafrica.crm.core.page

import java.util.*

/**
 * Abstract interface for pagination information
 *
 * @author Denis Gitonga
 */
interface Pageable {

     companion object {
         /**
          * Returns a [Pageable] instance representing no pagination setup
          */
         fun unpaged() = UnPaged.INSTANCE
     }

    /**
     * Returns whether the current [Pageable] contains pagination information
     *
     * @return
     */
    fun isPaged() = true

    /**
     * Returns whether the current [Pageable] does not contain pagination information
     *
     * @return
     */
    fun isUnPaged() = !isPaged()

    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    fun getPageNumber(): Int


    /**
     * Returns the number of items to be returned.
     *
     * @return the number of items of that page.
     */
    fun getPageSize(): Int


    /**
     * Return the offset to be taken according to the underlying page and page size.
     *
     * @return the offset taken
     */
    fun getOffset(): Int


    /**
     * Returns the [Pageable] requesting the next [Page]
     *
     * @return
     */
    fun next(): Pageable

    /**
     * Returns the previous [Pageable] or the first [Pageable] if the current one already is the first one.
     */
    fun previousOrFirst(): Pageable


    /**
     * Returns the [Pageable] requesting the first page.
     *
     * @return
     */
    fun first(): Pageable


    /**
     * Returns whether there's a previous [Pageable] we can access from the current one. Will return
     * false in case the current [Pageable] already refers to the first page.
     *
     * @return
     */
    fun hasPrevious(): Boolean


    /**
     * Returns an [Optional] so that it can easily be mapped on.
     *
     * @return
     */
    fun toOptional(): Optional<Pageable> {
        return if (isUnPaged())  Optional.empty() else Optional.of(this)
    }


}