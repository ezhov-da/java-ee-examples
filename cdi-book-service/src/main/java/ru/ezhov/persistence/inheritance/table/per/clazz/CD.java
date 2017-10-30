package ru.ezhov.persistence.inheritance.table.per.clazz;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Entity
@Table(name = "T_E_INHERITANCE_TABLE_PER_CLASS_CD")
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
