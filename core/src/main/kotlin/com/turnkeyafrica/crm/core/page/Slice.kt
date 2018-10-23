package com.turnkeyafrica.crm.core.page

/**
 * A slice of data that indicates whether there's a next or previous slice available. Allows to obtain a
 * [Pageable] to request a previous or next [Slice].
 *
 * @author Denis Gitonga
 */
interface Slice<T>: Iterable<T> {

    /**
     * Returns the number of the current [Slice]. Is always non-negative.
     *
     * @return the number of the current [Slice].
     */
    fun getNumber(): Int

    /**
     * Returns the size of the [Slice]
     *
     * @return the size of the [Slice]
     */
    fun getSize(): Int

    /**
     * Returns the number of elements currently on this [Slice]
     *
     * @return
     */
    fun getNumberOfElements(): Int

    /**
     * Returns the page content as [List]
     *
     * @return
     */
    fun getContent(): List<T>


    /**
     * Returns whether the [Slice] has content at all.
     *
     * @return
     */
    fun hasContent(): Boolean

    /**
     * Returns whether the current [Slice] is first one.
     *
     * @return
     */
    fun isFirst(): Boolean

    /**
     * Returns whether the current [Slice] is the last one.
     *
     * @return
     */
    fun isLast(): Boolean

    /**
     * Returns if there is a next [Slice]
     *
     * @return
     */
    fun hasNext(): Boolean

    /**
     * Returns if there is a previous [Slice]
     *
     * @return
     */
    fun hasPrevious(): Boolean


    /**
     * Returns the [Pageable] that's been used to request the current [Slice]
     *
     * @return
     */
    fun getPageable(): Pageable {
        return PageRequest.of(page = getNumber(), size = getSize())
    }

    /**
     * Returns the [Pageable] to request the next [Slice]. Can be null in case the current
     * [Slice] is already the last one. Clients should check [hasNext] before calling this method to make
     * sure receive a non-null value.
     *
     * @return
     */
    fun nextPageable(): Pageable?


    /**
     * Returns the [Pageable] to request the previous [Slice]. Can be null in case the current
     * [Slice] is already the first one. Clients should check [hasPrevious] before calling this method to make
     * sure receive a non-null value.
     *
     * @return
     */
    fun previousPageable(): Pageable?


    /**
     * Returns a new [Slice] with the content of the current one mapped by the given [converter].
     *
     * @param converter must not be null.
     * @return a new [Slice] with the content of the current one mapped by the given [converter]
     */
    fun <U> map(converter: (T) -> U): Slice<U>
}