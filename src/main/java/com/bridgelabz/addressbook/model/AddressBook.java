package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "user_address_data")
public @Data class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    private String name;
    private String city;
    private String state;
    private String zipCode;

    @ElementCollection
    @CollectionTable(name="user_phone", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone_number")
    private List<String> phoneNumber;

    @ElementCollection
    @CollectionTable(name="user_email", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "email")
    private List<String> email;

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.getName();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zipCode = addressBookDTO.getZipCode();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.email = addressBookDTO.getEmail();
    }
}
