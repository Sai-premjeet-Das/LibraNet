package com.example.libranet.service;

import com.example.libranet.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LibraryService {

    private final Map<Integer, LibraryItem> catalog = new ConcurrentHashMap<>();
    private final Map<Integer, Double> fines = new ConcurrentHashMap<>();
    private static final double DAILY_FINE_RATE = 10.0;
    private static final int DEFAULT_LOAN_PERIOD = 14;


    @PostConstruct
    private void loadInitialData() {
        catalog.put(101, new Book(101, "The Hobbit", "J.R.R. Tolkien", 310));
        catalog.put(202, new AudioBook(202, "Dune", "Frank Herbert", 1260));
        catalog.put(303, new Emagazine(303, "National Geographic", "Various", 255));
        catalog.put(102, new Book(102, "1984", "George Orwell", 328));
    }

    public Collection<LibraryItem> getAllItems() {
        return catalog.values();
    }

    public LibraryItem findItemById(int id) {
        return catalog.get(id);
    }

    public String borrowItem(int id) {
        LibraryItem item = findItemById(id);
        if (item == null) return "Error: Item not found.";
        if (!item.isAvailable()) return "Error: Item is already borrowed.";

        item.borrow(DEFAULT_LOAN_PERIOD);
        return "Success: You borrowed '" + item.getTitle() + "'. It is due on " + item.getDueDate() + ".";
    }

    public String returnItem(int id) {
        LibraryItem item = findItemById(id);
        if (item == null) return "Error: Item not found.";
        if (item.isAvailable()) return "Info: This item was not borrowed.";

        LocalDate returnDate = LocalDate.now();
        LocalDate dueDate = item.getDueDate();
        String returnMessage = "Success: You returned '" + item.getTitle() + "'.";

        if (returnDate.isAfter(dueDate)) {
            long daysOverdue = ChronoUnit.DAYS.between(dueDate, returnDate);
            double fineAmount = daysOverdue * DAILY_FINE_RATE;
            fines.put(id, fines.getOrDefault(id, 0.0) + fineAmount);
            returnMessage += " The item was " + daysOverdue + " day(s) overdue. A fine of ₹" + fineAmount + " has been added.";
        }

        item.returnItem();
        return returnMessage;
    }
}