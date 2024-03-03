package dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;
    @Column(name = "city_name")
    private String street;

    @OneToOne
    private Person person;


    @ManyToOne
    private City city;


    public Address(String street) {
        this.street = street;

    }

    public void addPerson(Person person) {
        this.person = person;
        if (person != null) {
            person.setAddress(this);
        }
    }

}