package ru.ezhov.persistence.two.assotiation.many.to.many;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Entity
@Table(name = "T_E_TWO_ASSOTIATION_MANY_TO_MANY_CD")
public class CD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "cdList")
    private List<Artist> artistList;

    public List<Artist> getArtistList() {
        return artistList;
    }

    @Override
    public String toString() {
        return "CD{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
