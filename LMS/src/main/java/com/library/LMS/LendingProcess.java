package com.library.LMS;

import java.util.Date;

import static com.library.lms.LibraryLogger.logInfo;

public class LendingProcess {
    private Inventory inventory;
    private BookTransaction bookTransaction;

    public LendingProcess(Inventory inventory) {
        this.inventory = inventory;
    }

    public void checkoutBook(Book book, Patron patron) {
        if (inventory.getAvailableBooks().contains(book)) {
            inventory.addBorrowedBook(book);
            BookTransaction bookTransaction = new BookTransaction(book, patron, new Date(), null);
            patron.borrowBook(bookTransaction);
            bookTransaction.setBook(book);
            bookTransaction.setBorrowedDate(new Date());
            logInfo("Book - "+ book.getTitle() + " checked out successfully by " + patron.getName()
                    + " on " + bookTransaction.getBorrowedDate());
        } else {
            logInfo(book.getTitle() + " - This book is not available for checkout.");
        }
    }

    public void returnBook(Book book, Patron patron){
        if ((inventory.getBorrowedBooks()).contains(book)) {
            logInfo("Book - "+ book.getTitle() + " returned successfully by " + patron.getName() + " on " + new Date());
            inventory.removeBorrowedBook(book);
            BookTransaction bookTransaction = new BookTransaction(book, patron, null, new Date());
            patron.returnBook(bookTransaction);
        } else {
            logInfo("This " + book.getTitle() + " book was not borrowed by patron - " + patron.getName());
        }
    }
}
