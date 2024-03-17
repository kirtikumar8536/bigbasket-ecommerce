package com.bigbasket.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String buildingName;
    private String city;
    private String pinCode;
    private String state;
    private String country;

    @ManyToMany(mappedBy = "addresses") // comes from user's field
    private List<User> users = new ArrayList<>();


}

/*
@JoinColumn: Used for defining a single column in an owning entity that
            maps to a foreign key column in the referenced entity.
@JoinTable: Used for defining a join table when dealing with
         Many-to-Many relationships, where there's no explicit entity for the join table.
 orphanRemoval is specifically designed to remove entities
     that are no longer referenced by any other entities,while
 cascade = CascadeType.REMOVE will remove all associated entities
  when the parent entity is deleted, regardless of whether they are referenced by other entities.
*/
