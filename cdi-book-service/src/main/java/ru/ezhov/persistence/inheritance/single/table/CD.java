package ru.ezhov.persistence.inheritance.single.table;

import javax.persistence.Entity;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Entity
public class CD extends Item {
    private String number;

    public CD(String number) {
        this.number = number;
    }

    public CD(String name, String number) {
        super(name);
        this.number = number;
    }
}
