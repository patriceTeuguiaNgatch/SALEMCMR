package org.salem.domain.don;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonRepository extends JpaRepository<Don, Long> {

}