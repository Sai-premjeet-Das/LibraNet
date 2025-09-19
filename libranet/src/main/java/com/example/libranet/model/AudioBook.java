package com.example.libranet.model;

public class AudioBook extends LibraryItem {
    private final int durationInMinutes;

    public AudioBook(int itemID, String title, String author, int durationInMinutes) {
        super(itemID, title, author);
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String getDetails() {
        return "Audiobook: '" + getTitle() + "' by " + getAuthor() + " (" + durationInMinutes + " mins)";
    }
}