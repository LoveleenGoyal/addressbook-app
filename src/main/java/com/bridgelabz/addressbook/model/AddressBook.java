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
    private String address;

    @ElementCollection
    @CollectionTable(name="user_phone", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone_number")
    private List<String> phoneNumber;

    @ElementCollection
    @CollectionTable(name="user_email", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "email")
    private List<String> email;

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.name;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipCode = addressBookDTO.zipCode;
        this.phoneNumber = addressBookDTO.phoneNumber;
        this.email = addressBookDTO.email;
    }
}
