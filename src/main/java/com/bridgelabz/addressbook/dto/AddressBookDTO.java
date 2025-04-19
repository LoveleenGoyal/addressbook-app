package com.bridgelabz.addressbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "User Name Invalid")
    @NotBlank(message = "First name can not be empty")
    public String name;

    @NotBlank(message = "City cannot be empty")
    @NotNull(message = "City cannot be null")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid city")
    public String city;

    @NotNull(message = "State cannot be null")
    @NotBlank(message = "State cannot be blank")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid state")
    public String state;

    @NotBlank(message = "Zipcode cannot be empty")
    @Pattern(regexp = "^[1-9][0-9]{5}$")
    public String zipCode;

    @NotBlank(message = "Address cannot be empty")
    @Pattern(regexp = "[A-Za-z\\d\\s._+#()\\-]+$", message = "Invalid Address")
    public String address;

    @NotNull(message = "Phone number cannot be null")
    @Size(min = 1, message = "At least one phone number must be specified")
    public List<String> phoneNumber;

    @NotNull(message = "Email cannot be null")
    @Size(min = 1, message = "At least one email must be specified")
    public List<String> email;
}
