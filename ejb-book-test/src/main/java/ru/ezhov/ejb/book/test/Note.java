package ru.ezhov.ejb.book.test;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@NamedQuery(name = Note.FIND_ALL, query = "SELECT n FROM Note n")
public class Note implements Serializable {
    public static final String FIND_ALL = "Note.findAllNotes";

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "isHide")
    private boolean isHide;

    public Note(String name, boolean isHide) {
        this.name = name;
        this.isHide = isHide;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isHide() {
        return isHide;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", name=" + name +
                ", isHide=" + isHide +
                '}';
    }
}
