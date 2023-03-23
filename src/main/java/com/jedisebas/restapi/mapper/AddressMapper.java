package com.jedisebas.restapi.mapper;

import com.jedisebas.restapi.dto.AddressDto;
import com.jedisebas.restapi.entity.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public Address dtoToEntity(AddressDto addressDto) {
        return Address.builder()
                .city(addressDto.getCity())
                .houseNumber(addressDto.getHouseNumber())
                .street(addressDto.getStreet())
                .build();
    }

    public AddressDto entityToDto(Address address) {
        return AddressDto.builder()
                .city(address.getCity())
                .houseNumber(address.getHouseNumber())
                .street(address.getStreet())
                .build();
    }

    public AddressDto entityToDtoAnonymized(Address address) {
        return entityToDto(address);
    }
}
