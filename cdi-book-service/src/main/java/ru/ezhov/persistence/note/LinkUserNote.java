package ru.ezhov.persistence.note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by rrnezh on 28.10.2017.
 */
@Entity
@Table(name = "T_E_LINK_USER_NOTE")
public class LinkUserNote {
    @Id
    private int id;

    @NotNull
    @Min(1)
    @Column(name = "ID_USER")
    private int idUser;

    @NotNull
    @Min(1)
    @Column(name = "ID_NOTE")
    private int idNote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    @Override
    public String toString() {
        return "LinkUserNote{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idNote=" + idNote +
                '}';
    }
}
