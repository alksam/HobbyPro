package dat;

import dto.Hobby;
import dto.Phone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter


public class PersonInfo {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String street;
    private int zip;
    private String hobbyName;

    public PersonInfo(String firstName,
                      String lastName,
                      int age,
                      String phoneNumber, String street, int zip, String hobbyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.zip = zip;

        this.hobbyName = hobbyName;
    }


    public String ToString() {
        return "PersonInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", street='" + street + '\'' +
                ", zip=" + zip +
                ", hobbyName=" + hobbyName +
                '}';
    }


}
