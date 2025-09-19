package com.example.libranet.model;

import java.time.LocalDate;

public abstract class LibraryItem {
    private final int itemID;
    private final String title;
    private final String author;
    private boolean isAvailable;


    private LocalDate borrowDate;
    private LocalDate dueDate;

    public LibraryItem(int itemID, String title, String author) {
        this.itemID = itemID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }


    public int getItemID() { return itemID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public LocalDate getDueDate() { return dueDate; }


    public void borrow(int loanPeriodInDays) {
        if (this.isAvailable) {
            this.isAvailable = false;
            this.borrowDate = LocalDate.now();
            this.dueDate = this.borrowDate.plusDays(loanPeriodInDays);
        }
    }


    public void returnItem() {
        this.isAvailable = true;
        this.borrowDate = null;
        this.dueDate = null;
    }

    public abstract String getDetails();
}