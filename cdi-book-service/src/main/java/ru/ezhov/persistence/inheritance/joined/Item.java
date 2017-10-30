package ru.ezhov.persistence.inheritance.joined;

import javax.persistence.*;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "T_E_INHERITANCE_JOINED_ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }
}
