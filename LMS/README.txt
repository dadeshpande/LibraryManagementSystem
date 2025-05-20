The Book Class contains 4 fields and setters and getters for the same.

Patron class has 4 fields and it maintains book borrowed by Patron.

LibraryLogger is used to log info and errors.

Book Transaction Class extends Book class and has 4 fields with constructor and Setter Getters.

Inventory Class has 3 list of books named availableBooks, borrowedBooks, lstAllBooks and constructor and Getters Setters.
It also has below methods in it.
1. addAvailableBook
2. removeAvailableBook
3. updateBook
4. addBorrowedBook
5. removeBorrowedBook
6. listBorrowedBooks()
7. listBorrowedBooksByPatron(patron)
8. listAvailableBooks()
9. findBookByISBN(String isbn, List<Book> books)
10. findBookByAuthor(String author, List<Book> books) 
11. findBookByTitle(String title, List<Book> books)
12. findBookByPublicationYear(int publicationYear, List<Book> books)
13. printBookDetails(List<Book> books)
14. printBookDetails(Book book)
15. printBookTransactionDetails(List<BookTransaction> books)
16. printBookTransactionDetails(BookTransaction book)
17. getLstAllBooks()

Class LendingProcess has 2 fields inventory and bookTransaction.
It has following methods in it.
1. checkoutBook(Book book, Patron patron)
2. returnBook(Book book, Patron patron)
