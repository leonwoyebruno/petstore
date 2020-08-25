package com.petstore.repository;

import com.petstore.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface PetRepository  extends JpaRepository<Pet, Integer> {


}
