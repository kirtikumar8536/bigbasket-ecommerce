package com.bigbasket.services;

import com.bigbasket.payload.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);

    List<AddressDto> getAllAddress();

    AddressDto getAddress(Long addressId);

    AddressDto updateAddress(Long addressId,AddressDto addressDto);

    String deleteAddress(Long addressId);

}
