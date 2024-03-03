package dao.person;

import dat.PersonInfo;
import dto.Person;

import java.util.List;

public interface PersonIMP {

    Person addPerson(Person person);
    Person getPersonById(int id);
    Person updatePerson(Person person);

    void deletePerson(Person person);

    List<PersonInfo> fetchAll(int id);

}
