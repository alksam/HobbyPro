package dao.hobby;

import dto.Hobby;

public interface IHobbyIMP {

    Hobby addHobby(Hobby hobby);
    Hobby getHobbyById(int id);
    Hobby updateHobby(Hobby hobby);
    void deleteHobby(Hobby hobby);
}
