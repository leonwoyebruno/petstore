package com.petstore.repository;

import com.petstore.models.Pet;
import com.petstore.models.PetSex;
import com.petstore.models.PetTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"classpath:db\\insert-pet.sql"})
class PetRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    PetRepository petRepository;

    Pet testPetData;

    @BeforeEach
    void setUp() {

        testPetData = petRepository.findById(200).orElse(null);
        assertThat(testPetData).isNotNull();
        log.info("Test pet data retrieved from database -->" + testPetData);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createPetObject_thenSaveToDatabaseTest(){
        Pet pet = new Pet();
        pet.setAge(5);
        pet.setName("Lucky");
        pet.setSex(PetSex.MALE);
        pet.setTypes(PetTypes.DOG);
        pet.setBreed("bull dog");
        pet.setBirthDate(new Date());

        log.info("Create Pet Objet --->" + pet);
        assertThat(pet.getId()).isNull();

        //save pet object to the database
        pet = petRepository.save(pet);
        log.info("After saving pet object --->" + pet);
        assertThat(pet.getId()).isNotNull();
    }

    @Test
    void whenFindAllPetsIsCalled_thenRetreivePetsListTest(){

        List<Pet> allPets = petRepository.findAll();
        assertThat(allPets.size()).isEqualTo(8);
        log.info("All pets retreived from database -->" + allPets);
    }
    @Test
    void whenPetDataIsUpdated_thenUpdateDatabaseDetails(){

        assertThat(testPetData.getName()).isEqualTo("bobby");
        testPetData.setName("jiran");

        testPetData = petRepository.save(testPetData);
        assertThat(testPetData.getName()).isEqualTo("jiran");
    }

    @Test
    void whenDeleteIsCalled_thenDeletePetDataTest(){


        List<Pet> allPets = petRepository.findAll();
        assertThat(allPets).isNotNull();
        assertThat(allPets.size()).isEqualTo(8);

        //let's fetch the pet we want to delete
        Pet savePet = petRepository.findById(204).orElse(null);
        assertThat(savePet).isNotNull();
        petRepository.deleteById(204);

        Pet deletedPet = petRepository.findById(204).orElse(null);
        assertThat(deletedPet).isEqualTo(null);


        allPets = petRepository.findAll();
        assertThat(allPets).isNotNull();
        assertThat(allPets.size()).isEqualTo(7);
    }
}