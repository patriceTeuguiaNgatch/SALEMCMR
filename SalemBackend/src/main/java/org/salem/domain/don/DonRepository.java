package org.salem.domain.don;

import java.util.List;

import org.salem.domain.dto.DonPersistDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonRepository extends JpaRepository<Don, Long> {

    @Query("SELECT new org.salem.domain.dto.DonPersistDto(d.donId, d.address.roadNumber, d.address.town, d.address.zipCode,"
            + "d.kind, d.address.phoneNumber, d.comment, d.isConfidential, d.eDon, a.accountId, a.email, a.name.firstName, a.name.lastName)"
            + " FROM Don d INNER JOIN d.account a")
    List<DonPersistDto> findAllDon();

}