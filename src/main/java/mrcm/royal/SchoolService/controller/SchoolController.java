package mrcm.royal.SchoolService.controller;

import java.util.List;

import javax.validation.Valid;

import mrcm.royal.SchoolService.db.entity.School;
import mrcm.royal.SchoolService.db.service.SchoolService;
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
public class SchoolController {

    @Autowired
    private SchoolService schoolService;


    @PostMapping("/schools")
    public School createOne(@Valid @RequestBody School newSchool) {
      return schoolService.save(newSchool);
    }

    @GetMapping("/schools/{id}")
    public School readOne(@PathVariable Long id) {
      return schoolService.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @GetMapping("/schools")
    public List<School> readAll() {
        return schoolService.findAll();
    }

    @PutMapping("/schools/{id}")
    public School updateOne(@Valid @RequestBody School newSchool, @PathVariable Long id) {
        return schoolService.findById(id)
            .map(oldSchool -> {
                oldSchool.setName(newSchool.getName());
    
                return schoolService.save(oldSchool);
            })
            .orElseGet(() -> {
                newSchool.setId(id);
                return schoolService.save(newSchool);
            });
    }

    @DeleteMapping("/schools/{id}")
    public void deleteOne(@PathVariable Long id) {
        schoolService.deleteById(id);
    }

}