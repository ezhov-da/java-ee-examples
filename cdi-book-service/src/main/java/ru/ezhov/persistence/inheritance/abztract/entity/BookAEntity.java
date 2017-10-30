package ru.ezhov.persistence.inheritance.abztract.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Вах, лениво реализовывать )))
 * Created by rrnezh on 30.10.2017.
 */
//@Entity
public class BookAEntity extends ItemAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
