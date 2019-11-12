package mrcm.royal.SchoolService.db.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import mrcm.royal.SchoolService.db.entity.School;
import mrcm.royal.SchoolService.db.repository.SchoolRepository;


@Service
@Transactional
public class SchoolService extends AbstractService<School> {

    @Autowired
    private SchoolRepository repo;


    @Override
    protected JpaRepository<School, Long> getRepository() {
        return repo;    
    }

}