package com.kpi.lab.student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getList();
    Optional<Student> getStudent(Integer id);
    Student createStudent(String name, String surname, Integer age, Integer cathedra_id);
}
