package com.kpi.lab.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyRepositoryService implements FacultyService{

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getList() {
        List<Faculty> facultyList = new ArrayList<>();
        facultyRepository.findAll().forEach(facultyList::add);
        return facultyList;
    }

    @Override
    public Optional<Faculty> getFaculty(Integer id) {
        return facultyRepository.findById(id);
    }

    @Override
    public Faculty createFaculty(String nameFaculty, String descriptionFaculty) {
        Faculty faculty = Faculty.builder().name(nameFaculty).info(descriptionFaculty).build();
        return facultyRepository.save(faculty);
    }

//    @Override
//    public Faculty updateFaculty(Integer id, Faculty updatedFaculty) {
//        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nu such id:" + id));
//        faculty.setName(updatedFaculty.getName());
//        faculty.setInfo(updatedFaculty.getInfo());
//        return facultyRepository.save(faculty);
//    }
}
