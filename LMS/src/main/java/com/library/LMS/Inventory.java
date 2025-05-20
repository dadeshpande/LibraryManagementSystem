package com.library.LMS;

import java.util.ArrayList;
import java.util.List;

import static com.library.lms.LibraryLogger.logInfo;

public class Inventory {
    private List<Book> availableBooks;
    private List<Book> borrowedBooks;
    private List<Book> lstAllBooks;

    public Inventory() {
        this.availableBooks = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
    }

    public void addAvailableBook(Book book){
        availableBooks.add(book);
    }

    public void removeAvailableBook(Book book){
        if(availableBooks.contains(book)){
            availableBooks.remove(book);
            logInfo(book.getTitle() + " has removed from inventory");
        }
        else if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            logInfo(book.getTitle() + " has removed from inventory");
        }
        else{
            logInfo(book.getTitle() + " doesnt exist in inventory");
        }
    }

    public Book updateBook(Book book, String ISBN){
        if(availableBooks.contains(book)){
            for(int i=0; i< availableBooks.size(); i++){
                if(availableBooks.get(i).getIsbn().equalsIgnoreCase(ISBN)){
                    availableBooks.set(i,book);
                }
            }
            logInfo(book.getTitle() + " updated successfully");
        }
        else if(borrowedBooks.contains(book)){
            for(int i=0; i< borrowedBooks.size(); i++){
                if(borrowedBooks.get(i).getIsbn().equalsIgnoreCase(ISBN)){
                    borrowedBooks.set(i,book);
                }
            }
            logInfo(book.getTitle() + " updated successfully");
        }
        else{
            logInfo(book.getTitle() + " doesnt exist in inventry");
        }
        return book;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        if (availableBooks.contains(book)) {
            availableBooks.remove(book);
            borrowedBooks.add(book);
        }
    }

    public void removeBorrowedBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            availableBooks.add(book);
        }
    }

    public void listBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            logInfo("No borrowed books.");
            return;
        }
        printBookDetails(borrowedBooks);
    }

    public void listBorrowedBooksByPatron(Patron patron) {
        if (patron.getBorrowedBooks().isEmpty()) {
            logInfo("No borrowed books.");
            return;
        }
        printBookTransactionDetails(patron.getBorrowedBooks());
    }


    public void listAvailableBooks() {
        if (availableBooks.isEmpty()) {
            logInfo("No available books.");
            return;
        }
        for (Book book : availableBooks) {
            logInfo("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }

    public Book findBookByISBN(String isbn, List<Book> books) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBookByAuthor(String author, List<Book> books) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public Book findBookByTitle(String title, List<Book> books) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBookByPublicationYear(int publicationYear, List<Book> books) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublicationYear() == publicationYear) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void printBookDetails(List<Book> books){
        for (Book book : books) {
            logInfo("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", ISBN: " + book.getIsbn() + ", Year: " + book.getPublicationYear());
        }
    }

    public void printBookDetails(Book book){
        logInfo("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                ", ISBN: " + book.getIsbn() + ", Year: " + book.getPublicationYear());
    }

    public void printBookTransactionDetails(List<BookTransaction> books){
        for (BookTransaction book : books) {
            logInfo("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", ISBN: " + book.getIsbn() + ", Year: " + book.getPublicationYear() +
                    ", borrowedDate: " + book.getBorrowedDate() + ", returnedDate: " + book.getReturnedDate());
        }
    }

    public void printBookTransactionDetails(BookTransaction book){
        logInfo("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                ", ISBN: " + book.getIsbn() + ", Year: " + book.getPublicationYear() +
                ", borrowedDate: " + book.getBorrowedDate() + ", returnedDate: " + book.getReturnedDate());
    }

    public List<Book> getLstAllBooks(){
        lstAllBooks = new ArrayList<>();
        lstAllBooks.addAll(availableBooks);
        lstAllBooks.addAll(borrowedBooks);
        return lstAllBooks;
    }
}