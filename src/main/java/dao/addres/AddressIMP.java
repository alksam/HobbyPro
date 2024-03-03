package dao.addres;

import dat.ZipInfo;
import dto.Address;

import java.util.List;

public interface AddressIMP {

    Address addAddress(Address address);

    void addAddressToPerson(Address address, int PersonId);

    Address getAddressById(int id);
    Address updateAddress(Address address);
    void deleteAddress(Address address);

    List<ZipInfo> getAllPostcodesAndCities();




}
