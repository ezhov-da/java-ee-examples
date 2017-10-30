package ru.ezhov.persistence.entity.manipulation;

import javax.persistence.*;

/**
 * Created by rrnezh on 30.10.2017.
 */
@Entity
@Table(name = "T_E_MANIPULATION_ADDRESS")
public class AddressManipulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "STREET", nullable = false, length = 100)
    private String street;

    @Column(name = "ZIP_CODE", nullable = false, length = 100)
    private String zipCode;

    @Column(name = "COUNTRY", nullable = false, length = 100)
    private String country;

    @Column(name = "CITY", nullable = false, length = 100)
    private String city;

    public AddressManipulation() {
    }

    public AddressManipulation(String street, String zipCode, String country, String city) {
        this.street = street;
        this.zipCode = zipCode;
        this.country = country;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressManipulation{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
