package com.bigbasket.services.Impl;

import com.bigbasket.entites.Address;
import com.bigbasket.exception.APIException;
import com.bigbasket.exception.ResourceNotFoundException;
import com.bigbasket.payload.AddressDto;


import com.bigbasket.repositories.AddressRepository;
import com.bigbasket.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        //getting address object
        Address address = mapToEntity(addressDto);
        // check whether this address is already exist or not
        Address existedAddress = addressRepository.
                findByCountryAndStateAndCityAndPinCodeAndStreetAndBuildingName(
                        address.getCountry(), address.getState(), address.getCity(),
                        address.getPinCode(), address.getStreet(), address.getBuildingName());
        if (existedAddress != null) {
            throw new APIException("Address already exists with addressId: " + existedAddress.getAddressId());
        }
        Address savedAddress = addressRepository.save(address);
        return mapTODto(savedAddress);
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> listOfAddresses = addressRepository.findAll();
        List<AddressDto> listOfAddressDto = listOfAddresses.stream()
                .map(address -> mapTODto(address))
                .collect(Collectors.toList());

        return listOfAddressDto;
    }

    @Override
    public AddressDto getAddress(Long addressId) {
        //Address address = addressRepository.findById(addressId).get();
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with Id: " + addressId));
        //task:-handle exception--
        return mapTODto(address);
    }

    @Override
    public AddressDto updateAddress(Long addressId, AddressDto addressDto) {
//task-- don't update if address is already existed
        Address address = addressRepository.findById(addressId)
                                      .orElseThrow(() -> new ResourceNotFoundException("Address not found with Id: " + addressId));
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setCountry(addressDto.getCountry());
        address.setStreet(addressDto.getStreet());
        address.setBuildingName(addressDto.getBuildingName());
        address.setPinCode(addressDto.getPinCode());
        Address savedAddress = addressRepository.save(address);
        System.out.println(savedAddress.getAddressId());
        return mapTODto(savedAddress);
    }

    @Override
    public String deleteAddress(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with Id: " + addressId));
        addressRepository.deleteById(address.getAddressId());

        return "Address Deleted Successfully with addressId:" + address.getAddressId();
    }

    //using mapper module
    Address mapToEntity(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        return address;
    }

    AddressDto mapTODto(Address address) {
        AddressDto addressDto = modelMapper.map(address, AddressDto.class);
        return addressDto;
    }
}



