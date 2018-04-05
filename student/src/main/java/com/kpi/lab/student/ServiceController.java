package com.kpi.lab.student;

import com.kpi.lab.faculty.Faculty;
import com.kpi.lab.student.FeignClients.FacultyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceController {
    @Autowired
    private FacultyClient facultyClient;

    @GetMapping("/hello")
    public List<Faculty> getFaculties(){
        return facultyClient.getFaculties();
    }
}


