package ru.ezhov.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by rrnezh on 28.10.2017.
 */
@Entity
@Table(name = "T_E_TAG")
public class Tag {
    @Id
    private int id;

    @Column(name="ID_NOTE")
    private int idNote;

    @Column(name="TAG")
    private String name;
}
