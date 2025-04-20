package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository repository;
    @Override
    public AddressBook createUserAddressBook(AddressBookDTO addressBookDTO) {
        log.info("ACCESS DATABASE");
        AddressBook address = new AddressBook(addressBookDTO);
        log.debug("Created User Address book: " + address);
        return repository.save(address);
    }

    @Override
    public AddressBook getUserAddressBookById(int id) {
        log.info("Fetching User Address Details by ID: {}", id);
        Optional<AddressBook> userAddress = repository.findById(id);
        if (userAddress.isEmpty()) {
           log.error("No User found with ID: {}", id);
           throw new AddressBookException("User Address not found");
        }
        AddressBook address = userAddress.get();
        log.info("User Address found with ID: {}", id);
        return address;
    }

    @Override
    public List<AddressBook> getAllUserAddressBook() {
        log.info("Fetching address book of all users from database");
        return repository.findAll();
    }

    @Override
    public AddressBook updateUserAddressBook(int id, AddressBookDTO addressBookDTO) {
        log.debug("Updating User");
        Optional<AddressBook> addressBook = repository.findById(id);
        if (addressBook.isPresent()) {
            AddressBook address = addressBook.get();
            address.setName(addressBookDTO.name);
            address.setCity(addressBookDTO.city);
            address.setState(addressBookDTO.state);
            address.setZipCode(addressBookDTO.zipCode);
            address.setAddress(addressBookDTO.address);
            address.setPhoneNumber(addressBookDTO.phoneNumber);
            address.setEmail(addressBookDTO.email);
            log.info("Successfully updated user with ID: {}", id);
            return repository.save(address);
        } else {
            log.warn("Update failed. No user found with Id: {}", id);
            throw new AddressBookException("User with ID not found: " + id);
        }
    }

    @Override
    public void deleteUserAddressBook(int id) {
        if(!repository.existsById(id)) {
            throw new AddressBookException("User Address Book not found with ID: " + id);
        }
        log.info("Successfully deleted user with ID: {}", id);
        repository.deleteById(id);
    }
}
