package mrcm.royal.SchoolService.db.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import mrcm.royal.SchoolService.db.entity.Student;
import mrcm.royal.SchoolService.db.repository.StudentRepository;


@Service
@Transactional
public class StudentService extends AbstractService<Student> {

    @Autowired
    private StudentRepository repo;


    @Override
    protected JpaRepository<Student, Long> getRepository() {
        return repo;    
    }

}