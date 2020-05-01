package org.salem.service.assemler;

import org.salem.domain.don.Address;
import org.salem.service.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressAssembler {

    public AddressAssembler() {

    }

    AddressDto create(Address address) {

        AddressDto addressDto = new AddressDto();
        addressDto.setRoadNumber(address.getRoadNumber());
        addressDto.setTown(address.getTown());
        addressDto.setZipCode(address.getZipCode());

        return addressDto;
    }

}