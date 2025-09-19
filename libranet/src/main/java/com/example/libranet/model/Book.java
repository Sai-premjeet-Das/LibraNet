package com.example.libranet.model;

public class Book extends LibraryItem {
    private final int pageCount;

    public Book(int itemID, String title, String author, int pageCount) {
        super(itemID, title, author);
        this.pageCount = pageCount;
    }

    @Override
    public String getDetails() {
        return "Book: '" + getTitle() + "' by " + getAuthor() + " (" + pageCount + " pages)";
    }
}