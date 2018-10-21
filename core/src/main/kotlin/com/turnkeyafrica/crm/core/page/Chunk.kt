package com.turnkeyafrica.crm.core.page

import java.io.Serializable

abstract class Chunk< T>(
        private val _content: List<T>,
        private val _pageable: Pageable

): Slice<T>, Serializable {
    /**
     * @see Slice.getNumber()
     */
    override fun getNumber(): Int {
        return if (_pageable.isPaged()) _pageable.getPageNumber() else 0
    }

    /**
     * @see Slice.getSize()
     */
    override fun getSize(): Int {
        return if (_pageable.isPaged()) _pageable.getPageSize() else 0
    }

    /**
     * @see Slice.getNumberOfElements()
     */
    override fun getNumberOfElements(): Int = getContent().size

    /**
     * @see Slice.hasPrevious()
     */
    override fun hasPrevious(): Boolean = getNumber() > 0

    /**
     * @see Slice.isFirst()
     */
    override fun isFirst(): Boolean = !hasPrevious()

    /**
     * @see Slice.isLast()
     */
    override fun isLast(): Boolean = !hasNext()

    /**
     * @see Slice.nextPageable()
     */
    override fun nextPageable(): Pageable? {
        return if (hasNext()) _pageable.next() else Pageable.unpaged()
    }

    /**
     * @see Slice.previousPageable()
     */
    override fun previousPageable(): Pageable? {
        return if (hasPrevious()) _pageable.previousOrFirst() else Pageable.unpaged()
    }

    /**
     * @see Slice.hasContent()
     */
    override fun hasContent(): Boolean = getContent().isNotEmpty()

    /**
     * @see Slice.getContent()
     */
    override fun getContent(): List<T> = _content

    /**
     * @see Iterable.iterator()
     */
    override fun iterator(): Iterator<T> = getContent().iterator()


    /**
     * Applies the give [converter] to the content of the [Chunk]
     *
     * @param converter must not be null
     * @return
     */
    protected fun <U> getConvertedContent(converter: (T) -> U): List<U>{
        return this.map(converter).toList()
    }

    /**
     * @see Any.equals(Any)
     */
    override fun equals(other: Any?): Boolean {

        if (this === other) return true

        if (other !is Chunk<*>) return false

        val that = other as Chunk<*>

        val contentEqual = this._content == that._content
        val pageableEqual = this._pageable == that._pageable

        return contentEqual && pageableEqual
    }


    /**
     * @see Any.hashCode()
     */
    override fun hashCode(): Int {
        var result = 17
        result += 31 * _pageable.hashCode()
        result += 31 * _pageable.hashCode()

        return result
    }
}