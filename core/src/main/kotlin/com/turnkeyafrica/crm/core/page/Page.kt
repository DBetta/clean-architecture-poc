package com.turnkeyafrica.crm.core.page


/**
 * A page is a sublist of a list of objects. It allows gain information about the position of it in the containing
 * entire list.
 *
 * @author Denis Gitonga
 */
interface Page<T> : Slice<T> {

    /**
     * Returns the number of total pages
     * @return
     */
    fun getTotalPages(): Int

    /**
     * Returns the total amount of elements.
     */
    fun getTotalElements(): Long


    override fun <U> map(converter: (T) -> U): Page<U>

    companion object {
        /**
         * Creates a new empty [Page]
         *
         * @return
         */
        fun <T> empty(): Page<T> = empty(Pageable.unpaged())

        /**
         * Creates a new empty [Page] for the given [Pageable]
         *
         * @param pageable must not be null
         * @return
         */
        fun <T> empty(pageable: Pageable): Page<T> =
                PageImpl(emptyList(), pageable, 0)
    }

}