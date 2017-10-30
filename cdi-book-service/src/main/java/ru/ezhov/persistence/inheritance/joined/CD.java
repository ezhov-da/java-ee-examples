package ru.ezhov.persistence.inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Entity
@Table(name = "T_E_INHERITANCE_JOINED_CD")
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
