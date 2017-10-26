package ru.ezhov;

/**
 * Created by rrnezh on 26.10.2017.
 */
public class Book {
    private String title;
    private float price;
    private String description;
    private String number;

    public Book(String title, float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
