package com.jedisebas.restapi.repository;

import com.jedisebas.restapi.dto.AddressDto;
import com.jedisebas.restapi.entity.Address;
import com.jedisebas.restapi.entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer> {

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("UPDATE PersonalDetails p SET p.firstName = ?1, p.lastName = ?2, p.address = ?3, p.email = ?4 WHERE id = ?5")
    void updateById(String firstName, String lastName, Address address, String email, int id);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("UPDATE PersonalDetails p SET p.firstName = ?1 WHERE id = ?2")
    void updateFirstName(String firstName, int id);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("UPDATE PersonalDetails p SET p.lastName = ?1 WHERE id = ?2")
    void updateLastName(String lastName, int id);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("UPDATE PersonalDetails p SET p.email = ?1 WHERE id = ?2")
    void updateEmail(String email, int id);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("UPDATE PersonalDetails p SET p.address = ?1 WHERE id = ?2")
    void updateAddress(AddressDto address, int id);
}
