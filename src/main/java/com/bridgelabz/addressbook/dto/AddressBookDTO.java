package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class AddressBookDTO {
    public String name;
    public String city;
    public String state;
    public String zipCode;
    public List<String> phoneNumber;
    public List<String> email;
}
