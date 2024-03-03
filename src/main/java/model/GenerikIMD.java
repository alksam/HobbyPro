package model;

import dat.PersonInfo;
import dat.ZipInfo;
import dto.Hobby;
import dto.Person;
import dto.Phone;

import java.util.List;

public interface GenerikIMD  {

    List<Person> fetchAll(int id ,PersonInfo personInfo);

    List<Person> fetchAllPersonsWithHobby( int id );



    List<Phone> getAllPhoneNumbersFromPerson(Person person);
    List<Person> getpersonwithgivenhobby(String hobby);

    long getcountofpersonwithhobby(String hobby);
    List<Hobby> getallhobbies(String hobby , int count);
    Long getallpersonsinacity(String city  );
    int totalNumberOfPersonWithHobby(String hobby);

    List<Person> getUsersFromCity(String city);

    //List<ZipInfo> getZipAndCities();










}
