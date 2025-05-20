package com.library.LMS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Patron {
    private int patronId;
    private String name;
    private String email;
    private List<BookTransaction> borrowedBooks;


    public Patron() {
        borrowedBooks = new ArrayList<>();
    }

    public Patron(int patronId, String name, String email) {
        this.patronId = patronId;
        this.name = name;
        this.email = email;
        borrowedBooks = new ArrayList<>();
    }

    public int getPatronId() {
        return patronId;
    }

    public void setPatronId(int patronId) {
        this.patronId = patronId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void borrowBook(BookTransaction book) {
        borrowedBooks.add(book);
    }

    public void returnBook(BookTransaction book) {
        borrowedBooks.remove(book);
    }

    public List<BookTransaction> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(new BookTransaction(book, this, new Date(), null));
    }
}
