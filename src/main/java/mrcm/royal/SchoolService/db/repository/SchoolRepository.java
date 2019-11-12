package mrcm.royal.SchoolService.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mrcm.royal.SchoolService.db.entity.School;


@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    
}