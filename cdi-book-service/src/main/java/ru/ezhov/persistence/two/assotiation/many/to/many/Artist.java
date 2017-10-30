package ru.ezhov.persistence.two.assotiation.many.to.many;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Entity
@Table(name = "T_E_TWO_ASSOTIATION_MANY_TO_MANY_ARTIST")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @OrderBy("name ASC")
    @JoinTable(name = "T_E_TWO_ASSOTIATION_MANY_TO_MANY_LINK_CD_ARTIST",
            joinColumns = @JoinColumn(name = "ID_ARTIST "),
            inverseJoinColumns = @JoinColumn(name = "ID_CD"))
    private List<CD> cdList;

    public List<CD> getCdList() {
        return cdList;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
