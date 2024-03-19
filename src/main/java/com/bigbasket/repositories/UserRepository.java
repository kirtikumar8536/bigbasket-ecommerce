package com.bigbasket.repositories;

import com.bigbasket.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//
public interface UserRepository extends JpaRepository<User, Long> {

}
