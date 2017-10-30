package ru.ezhov.persistence.note;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rrnezh on 28.10.2017.
 */
@Entity
@Table(name = "T_E_NOTE_DETAIL")
public class NoteDetail {
    @Id

    private int id;

    @NotNull
    private String text;

    @Size(max = 1000)
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "NoteDetail{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
