package org.salem.service.don;

import org.salem.controller.dto.DonRequestDto;
import org.salem.domain.don.Address;
import org.salem.domain.don.Don;
import org.salem.domain.don.Edon;
import org.salem.domain.exception.InvalidDonTypeException;
import org.springframework.stereotype.Component;

@Component
public class DonFactory {

    private Edon eDonFinancial = Edon.DON_FINANCIAL;
    private Edon eDonMaterial = Edon.DON_MATERIAL;

    public DonFactory() {
    }

    public Don create(DonRequestDto donRequestDto) throws InvalidDonTypeException {

        Address address = new Address(donRequestDto.getRoadNumber(), donRequestDto.getTown(),
                donRequestDto.getZipCode(), donRequestDto.getPhoneNumber());
        String edon = donRequestDto.getEdon();

        if (edon.equals(eDonFinancial.toString())) {
            return new Don(address, donRequestDto.getKing(), donRequestDto.getComment(),
                    donRequestDto.getIsConfidential(), eDonFinancial);
        } else if (edon.equals(eDonMaterial.toString())) {
            return new Don(address, donRequestDto.getKing(), donRequestDto.getComment(),
                    donRequestDto.getIsConfidential(), eDonMaterial);

        } else {
            throw new InvalidDonTypeException(edon);
        }
    }
}