package ru.ezhov.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rrnezh on 28.10.2017.
 */
@Entity
@Table(name = "T_E_NOTE")
public class Note {
    @Id
    private int id;

    @NotNull
    @Size(min = 1, max = 256)
    private String name;

    @Column(name = "ISHIDE")
    private boolean hide;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hide=" + hide +
                '}';
    }
}
