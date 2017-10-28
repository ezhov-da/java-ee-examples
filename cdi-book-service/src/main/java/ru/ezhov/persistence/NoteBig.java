package ru.ezhov.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rrnezh on 28.10.2017.
 * <p>
 * Объект с полями в разных таблицах (Жирный объект)
 */

@Entity
@Table(name = "T_E_NOTE")

@SecondaryTables({
        @SecondaryTable(name = "T_E_NOTE_DETAIL"),
        @SecondaryTable(name = "T_E_NOTE_TIMESTAMP")
})
public class NoteBig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 256)
    private String name;

    @Column(name = "ISHIDE")
    private boolean hide;

    @NotNull
    @Column(table = "T_E_NOTE_TIMESTAMP")
    private Date dateAdd;
    @Column(table = "T_E_NOTE_TIMESTAMP")
    private Date dateEdit;

    @NotNull
    @Column(table = "T_E_NOTE_DETAIL")
    private String text;

    @Size(max = 1000)
    @Column(table = "T_E_NOTE_DETAIL")
    private String link;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "T_E_TAG",
            joinColumns=@JoinColumn(name = "ID", referencedColumnName = "ID"))
    @Column(name = "TAG")
    private List<String> tags = new ArrayList<>();

    public NoteBig() {
    }

    public NoteBig(
            @NotNull @Size(min = 1, max = 256) String name,
            boolean hide,
            @NotNull Date dateAdd,
            Date dateEdit,
            @NotNull String text,
            @Size(max = 1000) String link) {
        this.name = name;
        this.hide = hide;
        this.dateAdd = dateAdd;
        this.dateEdit = dateEdit;
        this.text = text;
        this.link = link;
    }

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "NoteBig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hide=" + hide +
                ", dateAdd=" + dateAdd +
                ", dateEdit=" + dateEdit +
                ", text='" + text + '\'' +
                ", link='" + link + '\'' +
                ", tags=" + tags +
                '}';
    }
}
