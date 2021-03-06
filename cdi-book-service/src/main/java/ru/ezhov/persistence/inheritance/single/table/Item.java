package ru.ezhov.persistence.inheritance.single.table;

import javax.persistence.*;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "T_E_INHERITANCE_SINGLE_TABLE")
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
