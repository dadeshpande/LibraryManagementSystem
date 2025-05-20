package com.library.LMS;

import java.util.List;
import java.util.ArrayList;

import static com.library.lms.LibraryLogger.logInfo;

public class LmSystemApplication {

    public static void main(String[] args) {

        // Create a list of books
        List<Book> books = new ArrayList<>();

        Book book1 = new Book("Book One", "Author One", "1234567890", 2020);
        Book book2 = new Book("Book Two", "Author Two", "0987654321", 2021);
        Book book3 = new Book("Book Three", "Author Three", "1122334455", 2022);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        Patron patron1 = new Patron(10, "Deepak", "da@gm.com");
        Patron patron2 = new Patron(1, "Pradeep", "pd@gm.com");

        List<Patron> patrons = new ArrayList<>();
        patrons.add(patron1);
        patrons.add(patron2);

        PatronManagement patronManagement = new PatronManagement();
        patronManagement.setPatrons(patrons);

        logInfo("Library Management System");
        logInfo("==========================");

        Inventory inventory = new Inventory();
        inventory.setAvailableBooks(books);
        inventory.setBorrowedBooks(new ArrayList<>());

        logInfo("List of all books:");
        List<Book> lstAll = inventory.getLstAllBooks();
        inventory.printBookDetails(lstAll);

        inventory.addAvailableBook(new Book("Four", "A Four", "159753", 2025));
        book3.setAuthor("DD");
        inventory.updateBook(book3, book3.getIsbn());

        LendingProcess lendingProcess = new LendingProcess(inventory);

        lendingProcess.checkoutBook(book1, patron1);

        lendingProcess.checkoutBook(book2, patron1);

        lendingProcess.returnBook(book1, patron1);


        lendingProcess.checkoutBook(book1, patron2);

        lendingProcess.checkoutBook(book2, patron2);

        logInfo("List of books borrowed by " + patron1.getName());
        inventory.listBorrowedBooksByPatron(patron1);

        logInfo("List of books borrowed by " + patron2.getName());
        inventory.listBorrowedBooksByPatron(patron2);

        lendingProcess.returnBook(book2, patron2);

        logInfo("List of all available books:");
        inventory.listAvailableBooks();

        logInfo("List of all borrowed books:");
        inventory.listBorrowedBooks();

        logInfo("List of all books:");
        inventory.printBookDetails(inventory.getLstAllBooks());

        logInfo("List of all patrons:");
        patronManagement.listPatrons();

        logInfo("Book with ISBN 1234567890: " );
        Book myBook = inventory.findBookByISBN("1234567890", inventory.getLstAllBooks());
        inventory.printBookDetails(myBook);

        inventory.removeAvailableBook(book1);
        logInfo("List of all available books after removing book1:");
        inventory.printBookDetails(inventory.getLstAllBooks());
    }
}
