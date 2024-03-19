package com.bigbasket.payload;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private Long addressId;
    private String street;
    private String buildingName;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}
