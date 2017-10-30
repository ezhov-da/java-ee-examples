package ru.ezhov.persistence.inheritance.table.per.clazz;

import javax.persistence.*;

/**
 * Важно! Для работы TABLE PER CLASS используется TABLE GENERATOR
 *
 * Created by rrnezh on 29.10.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "T_E_INHERITANCE_TABLE_PER_CLASS_ITEM")
public class Item {
    @Id
    @TableGenerator(
            name = "SHAPE_GEN",
            table = "T_E_INHERITANCE_TABLE_PER_CLASS_GENERATOR",
            pkColumnName = "NAME",
            valueColumnName = "ID",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SHAPE_GEN")
    protected int id;
    protected String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }
}
