package com.bigbasket.controller;

import com.bigbasket.payload.AddressDto;
import com.bigbasket.services.AddressService;
import com.bigbasket.services.Impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AddressController {
    //create address -http://localhost/create-address

    @Autowired
    private AddressService addressService;

    //http://localhost:8080/api/admin/create-address
    @PostMapping("/create-address")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        AddressDto savedAddressdto = addressService.createAddress(addressDto);
        return new ResponseEntity<AddressDto>(savedAddressdto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/admin/all-address
    @GetMapping("/all-address")
    public ResponseEntity<List<AddressDto>> getAllAddress() {
        List<AddressDto> allAddress = addressService.getAllAddress();
        return new ResponseEntity<List<AddressDto>>(allAddress, HttpStatus.FOUND);
    }

    //http://localhost:8080/api/admin/address/1
    @GetMapping("/address/{addressId}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable Long addressId) {
        AddressDto addressDto = addressService.getAddress(addressId);
        return new ResponseEntity<AddressDto>(addressDto, HttpStatus.FOUND);
    }

    // http://localhost:8080/api/admin/update-address/4
    @PutMapping("/update-address/{addressId}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable Long addressId,
                                                    @RequestBody AddressDto addressDto) {
        AddressDto updatedAddressDto = addressService.updateAddress(addressId, addressDto);
        return new ResponseEntity<AddressDto>(updatedAddressDto, HttpStatus.OK);
    }

    // http://localhost:8080/api/admin/delete-address/4
    @DeleteMapping("/delete-address/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId) {
        String status = addressService.deleteAddress(addressId);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

}
