package org.salem.service.assemler;

import java.util.ArrayList;
import java.util.List;

import org.salem.controller.dto.DonFinancialRequestDto;
import org.salem.controller.dto.DonMaterialRequestDto;
import org.salem.controller.dto.DonRequestDto;
import org.salem.domain.account.Account;
import org.salem.domain.don.Address;
import org.salem.domain.don.Don;
import org.salem.domain.account.Name;
import org.salem.domain.dto.DonPersistDto;
import org.salem.service.dto.AddressDto;
import org.salem.service.dto.DonAccountDto;
import org.salem.service.dto.DonDto;
import org.salem.service.dto.NameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DonAssembler {

    @Autowired
    private final AddressAssembler addressAssembler;

    @Autowired
    private final NameAssembler nameAssembler;

    public DonAssembler(final AddressAssembler addressAssembler, final NameAssembler nameAssembler) {

        this.addressAssembler = addressAssembler;
        this.nameAssembler = nameAssembler;
    }

    public DonDto create(final Don don) {

        final DonDto donDto = new DonDto();
        final Long dondId = don.getDonId();
        donDto.setDonId(dondId.toString());
        donDto.setValue(don.getValue());

        final Address address = don.getAddress();
        final AddressDto addressDto = this.addressAssembler.create(address);
        donDto.setAddressDto(addressDto);

        final Account account = don.getAccount();
        final DonAccountDto donAccountDto = this.create(account);
        donDto.setDonAccountDto(donAccountDto);

        donDto.setKind(don.getKind());
        donDto.setComment(don.getComment());
        donDto.setIsConfidential(don.getIsConfidential());
        donDto.setEdon(don.getEDon().toString());

        return donDto;
    }

    public Don create(final DonPersistDto donPersist) {

        final Don don = new Don();
        don.setDonId(donPersist.getDonId());

        don.setValue(donPersist.getValue());

        final Address address = new Address();
        address.setRoadNumber(donPersist.getRoadNumber());
        address.setTown(donPersist.getTown());
        address.setZipCode(donPersist.getZipCode());
        address.setPhoneNumber(donPersist.getPhoneNumber());
        don.setAddress(address);

        don.setKind(donPersist.getKind());
        don.setComment(donPersist.getComment());
        don.setIsConfidential(donPersist.getIsConfidential());
        don.setEDon(donPersist.getEDon());

        final Account account = new Account();
        account.setAccounId(donPersist.getAccountId());

        final Name name = new Name();
        name.setFirstName(donPersist.getFirstName());
        name.setLastName(donPersist.getLastName());
        account.setName(name);
        account.setEmail(donPersist.getEmail());
        don.setAccount(account);

        return don;
    }

    private DonAccountDto create(final Account account) {

        final DonAccountDto donAccountDto = new DonAccountDto();
        final Long accountId = account.getAccountId();
        donAccountDto.setAccountId(accountId.toString());

        final NameDto nameDto = this.nameAssembler.create(account.getName());
        donAccountDto.setNameDto(nameDto);

        donAccountDto.setEmail(account.getEmail());

        return donAccountDto;
    }

    public List<Don> createListDon(final List<DonPersistDto> donPersists) {

        final List<Don> dons = new ArrayList<>();
        for (final DonPersistDto donPersist : donPersists) {
            final Don don = this.create(donPersist);
            dons.add(don);
        }

        return dons;
    }

    public List<DonDto> createListDonDto(final List<Don> dons) {

        final List<DonDto> donDtos = new ArrayList<>();
        for (final Don don : dons) {
            final DonDto donDto = this.create(don);
            donDtos.add(donDto);
        }

        return donDtos;
    }

    public DonRequestDto create(DonMaterialRequestDto donMaterialRequestDto) {
        final DonRequestDto donRequestDto = new DonRequestDto();

        donRequestDto.setFirstName(donMaterialRequestDto.getFirstName());
        donRequestDto.setLastName(donMaterialRequestDto.getLastName());
        donRequestDto.setEmail(donMaterialRequestDto.getEmail());
        donRequestDto.setValue(donMaterialRequestDto.getValue());
        donRequestDto.setRoadNumber(donMaterialRequestDto.getRoadNumber());
        donRequestDto.setTown(donMaterialRequestDto.getTown());
        donRequestDto.setZipCode(donMaterialRequestDto.getZipCode());
        donRequestDto.setPhoneNumber(donMaterialRequestDto.getPhoneNumber());
        donRequestDto.setKind(donMaterialRequestDto.getKind());
        donRequestDto.setComment(donMaterialRequestDto.getComment());
        donRequestDto.setIsConfidential(donMaterialRequestDto.getIsConfidential());
        donRequestDto.setEdon(donMaterialRequestDto.getEdon());

        return donRequestDto;
    }

    public DonRequestDto create(DonFinancialRequestDto donFinancialRequestDto) {
        final DonRequestDto donRequestDto = new DonRequestDto();

        donRequestDto.setFirstName(donFinancialRequestDto.getFirstName());
        donRequestDto.setLastName(donFinancialRequestDto.getLastName());
        donRequestDto.setEmail(donFinancialRequestDto.getEmail());
        donRequestDto.setValue(donFinancialRequestDto.getValue());
        donRequestDto.setPhoneNumber(donFinancialRequestDto.getPhoneNumber());
        donRequestDto.setKind(donFinancialRequestDto.getKind());
        donRequestDto.setComment(donFinancialRequestDto.getComment());
        donRequestDto.setIsConfidential(donFinancialRequestDto.getIsConfidential());
        donRequestDto.setEdon(donFinancialRequestDto.getEdon());

        return donRequestDto;
    }

}