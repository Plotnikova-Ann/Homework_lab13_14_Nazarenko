package library1
import library.data.*
fun main() {
    val library = Library<LibraryItem>()
    library.add(
        LibraryItem.BookItem(
            Book("Война и мир", "Лев Толстой", 1869, "978-5-389-00000-1")
        )
    )
    library.add(
        LibraryItem.BookItem(
            Book("Преступление и наказание", "Фёдор Достоевский", 1866, "978-5-389-00001-2")
        )
    )
    library.add(
        LibraryItem.BookItem(
            Book("Мастер и Маргарита", "Михаил Булгаков", 1967, "978-5-389-00002-3")
        )
    )
    library.add(
        LibraryItem.MagazineItem(
            Magazine("National Geographic", 150, "March")
        )
    )
    library.add(
        LibraryItem.DVDItem(
            DVD("Интерстеллар", "Кристофер Нолан", 169)
        )
    )
    library.add(
        LibraryItem.DVDItem(
            DVD("Матрица", "Братья Вачовски", 136)
        )
    )
    val allItems = library.getAll()
    println("Всего элементов в библиотеке: ${library.size()}")
    allItems.forEach { println(it) }
    println("\n=== Фильтрация книг по году 1866 ===")
    val books = allItems.filterIsInstance<LibraryItem.BookItem>()
    val filteredBooks = books.filterByYear(1866)
    filteredBooks.forEach { println("${it.book.title} (${it.book.year})") }
    println("\n=== Сортировка по названию ===")
    val sortedItems = allItems.sortByTitle()
    sortedItems.forEach { item ->
        val title = when (item) {
            is LibraryItem.BookItem -> item.book.title
            is LibraryItem.MagazineItem -> item.magazine.title
            is LibraryItem.DVDItem -> item.dvd.title
        }
        println(title)
    }
    println("\n=== Группировка книг по автору ===")
    val groupedByAuthor = books.groupByAuthor()
    groupedByAuthor.forEach { (author, books) ->
        println("$author: ${books.map { it.book.title }}")
    }
    println("\n=== Общая продолжительность DVD ===")
    val dvds = allItems.filterIsInstance<LibraryItem.DVDItem>()
    val totalDuration = dvds.calculateTotalDuration()
    println("Всего минут: $totalDuration (${totalDuration / 60} ч ${totalDuration % 60} мин)")
}