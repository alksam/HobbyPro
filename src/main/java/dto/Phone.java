package dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Table(name = "phone")
@Getter
@Setter

@ToString
@NamedQueries(
        {
                @NamedQuery(name = "Phone.getAll", query = "SELECT p FROM Phone p"),

                @NamedQuery(name = "Phone.getByPerson", query = "SELECT p FROM Phone p WHERE p.person.id = :person ")
        }
)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    @ManyToOne
    private Person person;

    public Boolean validatePhone(String phone) {
        return phone.matches("[+]45+[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
    }


}
