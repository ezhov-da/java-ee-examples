package ru.ezhov.persistence.two.assotioation;

import javax.persistence.*;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Entity
@Table(name = "T_E_ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", customer=" + customer +
                '}';
    }
}
