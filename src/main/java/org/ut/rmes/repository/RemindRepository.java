package org.ut.rmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ut.rmes.entity.Remind;

public interface RemindRepository extends JpaRepository<Remind, Long> {

}

