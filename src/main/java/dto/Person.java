package dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "person")
@ToString
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),


})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "age")
    private int age;
    @Column(name = "last_edited")
    private LocalDate date ;

    @PreUpdate
    public void setLastEdited() {
        date = LocalDate.now();
    }
   @OneToOne
   private Address address;

   @OneToMany(mappedBy = "person")
   private Set<Phone> phones = new HashSet<>();

@OneToMany(mappedBy = "person")
private Set<Hobby> hobbies = new HashSet<>();


    public Person(String firstname, String lastname, int age,LocalDate date) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.date = LocalDate.now();
    }

    public void addPhone(Phone phone) {
        this.phones = phones;
if (phone.getPerson() != this){
        phone.setPerson(this);
    }
}

        public void addHobby(Hobby hobby) {
            this.hobbies = hobbies;
            if (hobby.getPerson() != this){
                hobby.setPerson(this);
            }
        }
        public void addAddress(Address address) {
            this.address = address;
            if (address.getPerson() != this){
                address.setPerson(this);
            }
        }
}
