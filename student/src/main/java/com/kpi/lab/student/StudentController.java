package com.kpi.lab.student;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/api/students")
    public List<Student> getFaculties(){
        return studentService.getList();

    }

    @GetMapping("/api/students/{id}")
    public Student getFaculty(@PathVariable Integer id){
        return studentService.getStudent(id).get();
    }

    @PostMapping("/api/students")
    public ResponseEntity createFaculty(@RequestBody Student newStudent, HttpServletRequest servletRequest){
        Student student = studentService.createStudent(newStudent.getName(),newStudent.getSurname(), newStudent.getAge(),newStudent.getCathedraId());
        URI uri = ServletUriComponentsBuilder.fromServletMapping(servletRequest)
                .path("/api/students/{id}")
                .buildAndExpand(student.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
