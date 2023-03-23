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
@Table(name = "personal_details")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = DataStoreConstants.FIRST_NAME)
    private String firstName;

    @Column(name = DataStoreConstants.LAST_NAME)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DataStoreConstants.ADDRESS_ID, referencedColumnName = "id")
    private Address address;

    private String email;
}
