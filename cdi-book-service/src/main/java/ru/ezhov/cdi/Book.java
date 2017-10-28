package ru.ezhov.cdi;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rrnezh on 26.10.2017.
 */

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ContainsChar(checkChar = "A")
    private String title;
    private double price;
    private String description;
    private String number;

    public Book() {
    }

    public Book(String title, double price, String description, String number) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
