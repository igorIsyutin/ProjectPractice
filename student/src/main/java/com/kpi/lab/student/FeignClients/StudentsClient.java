package com.kpi.lab.student.FeignClients;

import com.kpi.lab.student.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("student")
public interface StudentsClient {
    @RequestMapping(method = RequestMethod.GET, value = "api/students")
    List<Student> getStudents();
}
