package com.jedisebas.restapi.entity;

import com.jedisebas.restapi.constants.DataStoreConstants;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String street;

    @Column(name = DataStoreConstants.HOUSE_NUMBER)
    private String houseNumber;

    private String city;

    @OneToOne(mappedBy = "address")
    private PersonalDetails personalDetails;
}
