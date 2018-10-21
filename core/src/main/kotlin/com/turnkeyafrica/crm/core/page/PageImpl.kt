package com.turnkeyafrica.crm.core.page

/**
 * Basic [Page] implementation
 *
 * @author Denis Gitonga
 */
class PageImpl<T>(private val _content: List<T>,
                  _pageable: Pageable,
                  private var _total: Long) : Page<T>,
        Chunk<T>(_content, _pageable) {

    init {
        _total = _pageable.toOptional()
                .filter { _content.isNotEmpty() }
                .filter { it.getOffset() + it.getPageSize() > _total }
                .map { it.getOffset() + _content.size }
                .map { it.toLong() }
                .orElse(_total)
    }


    /**
     * Creates a new [PageImpl] with the given content. This will result in the created [Page] being identical
     * to the entire [List].
     *
     * @param _content must not be {@literal null}.
     */
    constructor(_content: List<T>) : this(_content, Pageable.unpaged(), _content.size.toLong())

    /**
     * @see Page.getTotalPages()
     */
    override fun getTotalPages(): Int {
        return if (getSize() == 0) 0
        else Math.ceil(_total.toDouble() / getSize().toDouble()).toInt()
    }

    /**
     * @see Page.getTotalElements()
     */
    override fun getTotalElements(): Long = _total

    /**
     * @see Page.hasNext()
     */
    override fun hasNext(): Boolean = getNumber() + 1 < getTotalPages()

    /**
     * @see Page.isLast()
     */
    override fun isLast(): Boolean = !hasNext()


    override fun <U> map(converter: (T) -> U): Page<U> {
        return PageImpl(getConvertedContent(converter), getPageable(), _total)
    }

    /**
     * @see Any.toString
     */
    override fun toString(): String =
            String.format("Page %s of %d", getNumber() + 1, getTotalPages())


    /**
     * @see Any.equals(Any)
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is PageImpl<*>) return true

        val that = other as PageImpl<*>

        return this._total == that._total && super.equals(other)
    }

    /**
     * @see Any.hashCode()
     */
    override fun hashCode(): Int {
        var result = 17

        result += 31 * (_total xor _total.ushr(32)).toInt()
        result += 31 * super.hashCode()

        return result
    }
}
