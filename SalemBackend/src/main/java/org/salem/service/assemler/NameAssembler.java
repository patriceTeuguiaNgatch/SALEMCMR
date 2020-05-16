package org.salem.service.assemler;

import org.salem.domain.account.Name;
import org.salem.service.dto.NameDto;
import org.springframework.stereotype.Component;

@Component
public class NameAssembler {

    public NameAssembler() {
    }

    public NameDto create(final Name name) {
        final NameDto nameDto = new NameDto();
        nameDto.setFirstName(name.getFirstName());
        nameDto.setLastName(name.getLastName());

        return nameDto;
    }

    public Name create(final NameDto nameDto) {
        final Name name = new Name();
        name.setFirstName(nameDto.getFirstName());
        name.setLastName(nameDto.getLastName());

        return name;
    }

    public Name createName(final String firstName, final String lastName) {
        return new Name(firstName, lastName);
    }

    public NameDto createNameDto(final String firstName, final String lastName) {
        return new NameDto(firstName, lastName);
    }

}