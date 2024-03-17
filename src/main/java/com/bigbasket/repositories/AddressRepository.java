package com.bigbasket.repositories;

import com.bigbasket.entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}


//@Repository
//@EnableJpaRepositories