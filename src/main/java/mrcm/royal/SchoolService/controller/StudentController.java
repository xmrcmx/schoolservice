package mrcm.royal.SchoolService.controller;

import java.util.List;

import javax.validation.Valid;

import mrcm.royal.SchoolService.db.entity.Student;
import mrcm.royal.SchoolService.db.service.StudentService;
import mrcm.royal.SchoolService.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    @Autowired
    private StudentService StudentService;


    @PostMapping("/students")
    public Student createOne(@Valid @RequestBody Student newStudent) {
      return StudentService.save(newStudent);
    }

    @GetMapping("/students/{id}")
    public Student readOne(@PathVariable Long id) {
      return StudentService.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @GetMapping("/students")
    public List<Student> readAll() {
        return StudentService.findAll();
    }

    @PutMapping("/students/{id}")
    public Student updateOne(@Valid @RequestBody Student newStudent, @PathVariable Long id) {
        return StudentService.findById(id)
            .map(oldStudent -> {
                oldStudent.setSchoolNo(newStudent.getSchoolNo());
                oldStudent.setName(newStudent.getName());
    
                return StudentService.save(oldStudent);
            })
            .orElseGet(() -> {
                newStudent.setId(id);
                return StudentService.save(newStudent);
            });
    }

    @DeleteMapping("/students/{id}")
    public void deleteOne(@PathVariable Long id) {
        StudentService.deleteById(id);
    }

}