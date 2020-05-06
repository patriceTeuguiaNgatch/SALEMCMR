package org.salem.service.don;

import java.util.List;
import java.util.logging.Logger;

import org.salem.controller.dto.DonRequestDto;
import org.salem.domain.don.Don;
import org.salem.domain.don.DonRepository;
import org.salem.domain.dto.DonPersistDto;
import org.salem.domain.exception.InvalidDonTypeException;
import org.salem.service.assemler.DonAssembler;
import org.salem.service.dto.DonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonService {

    @Autowired
    private final DonFactory donFactory;
    @Autowired
    private final DonAssembler donAssembler;
    @Autowired
    private final DonRepository donRepository;

    private static final Logger LOGGER = Logger.getLogger(DonService.class.getName());

    public DonService(final DonFactory donFactory, final DonAssembler donAssembler, final DonRepository donRepository) {
        this.donFactory = donFactory;
        this.donAssembler = donAssembler;
        this.donRepository = donRepository;

    }

    public Don save(final Don don) {

        LOGGER.info("Create the don : " + don.getKind() + " : " + LOGGER.getName());

        final Don donSave = this.donRepository.save(don);
        return donSave;
    }

    public DonDto Create(Don don) {
        return this.donAssembler.create(don);
    }

    public Don Create(DonRequestDto donRequestDto) throws InvalidDonTypeException {
        return this.donFactory.create(donRequestDto);
    }

    public List<DonDto> findAllDon() {
        List<DonPersistDto> donPersists = this.donRepository.findAllDon();
        List<Don> dons = this.donAssembler.createListDon(donPersists);
        List<DonDto> donDtos = this.donAssembler.createListDonDto(dons);

        return donDtos;
    }

}