package org.salem.service.assemler;

import org.salem.domain.don.Don;
import org.salem.service.dto.AddressDto;
import org.salem.service.dto.DonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DonAssembler {

    @Autowired
    private final AddressAssembler addressAssembler;

    public DonAssembler(final AddressAssembler addressAssembler) {

        this.addressAssembler = addressAssembler;
    }

    public DonDto create(final Don don) {
        final DonDto donDto = new DonDto();

        donDto.setDonId(don.getDonId().toString());

        AddressDto addressDto = this.addressAssembler.create(don.getAddress());
        donDto.setAddressDto(addressDto);

        donDto.setKing(don.getKing());
        donDto.setComment(don.getComment());
        donDto.setIsConfidential(don.getIsConfidential());
        donDto.setEdon(don.getEDon().toString());

        return donDto;
    }

}