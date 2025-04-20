package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {
    AddressBook createUserAddressBook(AddressBookDTO addressBookDTO);
    AddressBook getUserAddressBookById(int id);
    List<AddressBook> getAllUserAddressBook();
    AddressBook updateUserAddressBook(int id, AddressBookDTO addressBookDTO);
    void deleteUserAddressBook(int id);
}
