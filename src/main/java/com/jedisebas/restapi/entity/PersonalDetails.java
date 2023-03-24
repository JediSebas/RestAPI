package com.jedisebas.restapi.entity;

import com.jedisebas.restapi.constants.DataStoreConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "person_to_event",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> registeredEvents;
}
