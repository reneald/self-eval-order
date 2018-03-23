package be.reneald.api.customers;

import be.reneald.domain.customers.Address;

import javax.inject.Named;

@Named
public class AddressMapper {

    public AddressDto toDto(Address address) {
        return AddressDto.addressDto()
                .withStreetName(address.getStreetName())
                .withHouseNumber(address.getHouseNumber())
                .withPostCode(address.getPostCode())
                .withCity(address.getCity());
    }

    public Address toDomain(AddressDto addressDto) {
        return Address.AddressBuilder.address()
                .withStreetName(addressDto.getStreetName())
                .withHouseNumber(addressDto.getHouseNumber())
                .withPostCode(addressDto.getPostCode())
                .withCity(addressDto.getCity())
                .build();
    }
}
