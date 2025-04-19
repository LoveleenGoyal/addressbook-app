package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {
    private String name;
    private String city;
    private String state;
    private String zipCode;

    private List<String> phoneNumber;
    private List<String> email;
}
