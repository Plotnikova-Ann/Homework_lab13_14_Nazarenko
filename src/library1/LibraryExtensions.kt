package library1
import library.data.Book
import library.data.DVD
fun List<LibraryItem.BookItem>.filterByYear(year: Int): List<LibraryItem.BookItem> {
    return this.filter { it.book.year == year }
}
fun List<LibraryItem>.sortByTitle(): List<LibraryItem> {
    return this.sortedBy { item ->
        when (item) {
            is LibraryItem.BookItem -> item.book.title
            is LibraryItem.MagazineItem -> item.magazine.title
            is LibraryItem.DVDItem -> item.dvd.title
        }
    }
}
fun List<LibraryItem.BookItem>.groupByAuthor(): Map<String, List<LibraryItem.BookItem>> {
    return this.groupBy { it.book.author }
}
fun List<LibraryItem.DVDItem>.calculateTotalDuration(): Int {
    return this.sumOf { it.dvd.duration }
}
