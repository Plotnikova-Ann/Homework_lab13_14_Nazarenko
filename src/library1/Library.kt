package library1
class Library<T> {
    private val items = mutableListOf<T>()
    fun add(item: T) {
        items.add(item)
    }
    fun getAll(): List<T> = items.toList()
    fun clear() {
        items.clear()
    }
    fun size(): Int = items.size
}