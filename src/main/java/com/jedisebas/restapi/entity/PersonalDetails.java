package com.jedisebas.restapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "personal_details", schema = "personal_details")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
}
