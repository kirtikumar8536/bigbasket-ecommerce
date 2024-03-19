package com.bigbasket.payload;


import com.bigbasket.entites.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;

    private String firstName;

    private String lastName;

    private String mobileNo;

    private String email;

    private String password;

    private List<Address> addresses = new ArrayList<>();
}
