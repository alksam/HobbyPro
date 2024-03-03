package dao.addres;

import dto.Address;

public interface AddressIMP {

    Address addAddress(Address address);

    void addAddressToPerson(Address address, int PersonId);

    Address getAddressById(int id);
    Address updateAddress(Address address);
    void deleteAddress(Address address);


}
