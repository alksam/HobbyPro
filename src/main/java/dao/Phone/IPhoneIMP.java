package dao.Phone;

import dto.Phone;

public interface IPhoneIMP {

    Phone addPhone(Phone phone);
    Phone getPhoneById(int id);
    Phone updatePhone(Phone phone);
    void deletePhone(Phone phone);

}
