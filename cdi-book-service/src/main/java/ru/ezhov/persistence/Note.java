package ru.ezhov.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", insertable = false, updatable = false)
    private NoteDetail noteDetail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", insertable = false, updatable = false)
    private NoteDate noteDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NOTE", insertable = false, updatable = false)
    private List<Tag> tagList = new ArrayList<>();

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
                ", noteDetail=" + noteDetail +
                ", noteDate=" + noteDate +
                ", tagList=" + tagList +
                '}';
    }
}
