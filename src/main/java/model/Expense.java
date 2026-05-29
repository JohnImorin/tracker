package model;

import java.time.LocalDate;
import java.util.UUID;

public class Expense {


    private final UUID id;
    private double amount;
    private String category;
    private String title;
    private LocalDate date; ;

    public Expense(UUID id, double amount, String category, String title, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.title = title;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }
}
