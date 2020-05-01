package org.salem.service.assemler;

import org.salem.domain.don.Name;
import org.salem.service.dto.NameDto;
import org.springframework.stereotype.Component;

@Component
public class NameAssembler {

    public NameAssembler() {
    }

    public NameDto create(Name name) {
        NameDto nameDto = new NameDto();
        nameDto.setFirstName(name.getFirstName());
        nameDto.setLastName(name.getLastName());

        return nameDto;
    }

    public Name create(NameDto nameDto) {
        Name name = new Name();
        name.setFirstName(nameDto.getFirstName());
        name.setLastName(nameDto.getLastName());

        return name;
    }

}