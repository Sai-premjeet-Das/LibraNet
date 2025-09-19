package com.example.libranet.model;

public class Emagazine extends LibraryItem {
    private final int issueNumber;

    public Emagazine(int itemID, String title, String author, int issueNumber) {
        super(itemID, title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getDetails() {
        return "E-Magazine: '" + getTitle() + "', Issue: " + issueNumber;
    }
}