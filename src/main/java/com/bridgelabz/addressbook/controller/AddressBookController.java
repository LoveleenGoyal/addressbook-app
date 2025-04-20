package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.IAddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address_book")
public class AddressBookController {
    @Autowired
    private IAddressBookService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createUserBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook address = service.createUserAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Address Data created Successfully", address);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getUserBook(@PathVariable("id") int id) {
        AddressBook address = service.getUserAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get call for ID successful", address);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    @GetMapping("/display")
    public ResponseEntity<ResponseDTO> displayUsers() {
        List<AddressBook> addressBookList = service.getAllUserAddressBook();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", addressBookList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateUserAddressBook(@PathVariable("id") int id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook updatedAddressBook = service.updateUserAddressBook(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated User Address data for ID: " + id, updatedAddressBook);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteUserBook(@PathVariable("id") int id) {
        service.deleteUserAddressBook(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
