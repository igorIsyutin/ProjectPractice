package com.kpi.lab.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentRepositoryService implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getList() {
        List<Student> studentsList = new ArrayList<>();
        studentRepository.findAll().forEach(studentsList::add);
        return studentsList;
    }

    @Override
    public Optional<Student> getStudent(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student createStudent(String name, String surname, Integer age, Integer cathedra_id) {
        Student student = Student.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .cathedraId(cathedra_id)
                .build();
        return studentRepository.save(student);
    }
}
