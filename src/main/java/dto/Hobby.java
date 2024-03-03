package dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hobby")
@Getter
@Setter
@NoArgsConstructor
@NamedQueries(
        {

                @NamedQuery(name = "Hobby.getAll", query = "SELECT h FROM Hobby h"),
                @NamedQuery(name = "Hobby.getByName", query = "SELECT h FROM Hobby h WHERE h.hobbyName LIKE :name")

        }
)
@ToString
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String hobbyName;
    @Column(name = "wikilink")
    private String wikilink;
    @Column(name = "category")
    private String category;


    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private Person person;

    public Hobby(String hobbyName, String wikilink, String category, Type type) {
        this.hobbyName = hobbyName;
        this.wikilink = wikilink;
        this.category = category;
        this.type = type;


    }

    public void addPerson(Person person) {
        this.person = person;
        if (person != null) {
            person.getHobbies().add(this);
        }
    }


}
