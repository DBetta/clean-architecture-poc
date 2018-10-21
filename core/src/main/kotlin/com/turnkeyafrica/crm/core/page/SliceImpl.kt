package com.turnkeyafrica.crm.core.page

/**
 * Default implementation of [Slice]
 *
 * @author Denis Gitonga
 */
class SliceImpl<T>(
        private val _content: List<T>,
        private val _pageable: Pageable,
        private val _hasNext: Boolean
) : Chunk<T>(_content, _pageable) {

    /**
     * Creates a new [SliceImpl] with the given content. This will result in the created [Slice] being
     * identical to the entire [List].
     *
     * @param _content must not be null
     */
    constructor(_content: List<T>): this(_content, Pageable.unpaged(), false)

    /**
     * @see Slice.hasNext()
     */
    override fun hasNext(): Boolean = _hasNext

    /**
     * @see Slice.map
     */
    override fun <U> map(converter: (T) -> U): Slice<U> {
        return SliceImpl(getConvertedContent(converter), _pageable, _hasNext)
    }

    /**
     * @see Any.toString()
     */
    override fun toString(): String = String.format("Slice %d", getNumber())

    /**
     * @see Any.equals
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is SliceImpl<*>) return false

        val that = other as SliceImpl<*>

        return this._hasNext == that._hasNext && super.equals(other)
    }

    /**
     * @see Any.hashCode()
     */
    override fun hashCode(): Int {
        var result = 17

        result += 31 * (if(_hasNext) 1 else 0)
        result += 31 * super.hashCode()

        return result
    }
}