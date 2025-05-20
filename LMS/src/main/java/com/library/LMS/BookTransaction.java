package com.library.LMS;

import java.util.Date;

public class BookTransaction extends Book {
    private Book book;
    private Patron patron;
    private Date borrowedDate;
    private Date returnedDate;

    public BookTransaction(Book book, Patron patron, Date borrowedDate, Date returnedDate) {
        super(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear());
        this.patron = patron;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
}
