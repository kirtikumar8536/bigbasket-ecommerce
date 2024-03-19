package com.bigbasket.repositories;

import com.bigbasket.entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


    Address findByCountryAndStateAndCityAndPinCodeAndStreetAndBuildingName(String country, String state,
                                                                           String city, String pinCode,
                                                                           String street, String buildingName);


}


//@Repository
//@EnableJpaRepositories