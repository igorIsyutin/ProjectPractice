package com.kpi.lab.faculty;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/")
    public String map(){
        return "<a href=\"/api/faculties\">/api/faculties</a> + " +
                "<br />" +
                "<a href=\"/api/faculties/1\">/api/faculties/{id}</a>";
    }

    @GetMapping("/api/faculties")
    public List<Faculty> getFaculties(){
        return facultyService.getList();

    }

    @GetMapping("/api/faculties/{id}")
    public Faculty getFaculty(@PathVariable Integer id){
        return facultyService.getFaculty(id).get();
    }

    @PostMapping("/api/faculties")
    public ResponseEntity createFaculty(@RequestBody Faculty newFaculty, HttpServletRequest servletRequest){
        Faculty faculty = facultyService.createFaculty(newFaculty.getName(),newFaculty.getInfo());
        URI uri = ServletUriComponentsBuilder.fromServletMapping(servletRequest)
                .path("/api/faculties/{id}")
                .buildAndExpand(faculty.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    //@Value("${my.message}")
    private String config;
    @Autowired
    private FacultyProp facultyProp;

    @GetMapping("/api/faculty/config")
    public String getConfig(){
        return facultyProp.getPropety();
    }

//    @PostMapping("/api/faculties/{id}")
//    public ResponseEntity<Faculty> updateFaculty(@PathVariable Integer id, Faculty faculty){
//        return ResponseEntity.ok(facultyService.updateFaculty(id,faculty));
//    }
}
