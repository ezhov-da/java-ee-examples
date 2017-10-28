package ru.ezhov.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by rrnezh on 28.10.2017.
 */
@Entity
@Table(name = "T_E_NOTE_TIMESTAMP")
public class NoteDate {
    @Id
    private int id;
    private Date dateAdd;
    private Date dateEdit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    @Override
    public String toString() {
        return "NoteDate{" +
                "id=" + id +
                ", dateAdd=" + dateAdd +
                ", dateEdit=" + dateEdit +
                '}';
    }
}
