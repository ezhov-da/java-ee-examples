package ru.ezhov.persistence.entity.manipulation;

import javax.persistence.*;

/**
 * Created by rrnezh on 30.10.2017.
 */
@Entity
@Table(name = "T_E_MANIPULATION_CUSTOMER")
public class CustomerManipulation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer")
    @SequenceGenerator(
            name = "customer", sequenceName = "S_CUSTOMER",allocationSize = 1
    )
    private int id;

    @Column(name = "LAST_NAME", nullable = false, length = 100)
    private String lastName;

    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    private String firstName;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "ADDRESS_FK", referencedColumnName = "ID")
    private AddressManipulation addressManipulation;

    public CustomerManipulation() {
    }

    public CustomerManipulation(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressManipulation getAddressManipulation() {
        return addressManipulation;
    }

    public void setAddressManipulation(AddressManipulation addressManipulation) {
        this.addressManipulation = addressManipulation;
    }

    @Override
    public String toString() {
        return "CustomerManipulation{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", addressManipulation=" + addressManipulation +
                '}';
    }
}
