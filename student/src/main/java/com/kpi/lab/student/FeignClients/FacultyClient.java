package com.kpi.lab.student.FeignClients;

import com.kpi.lab.faculty.Faculty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("faculty")
public interface FacultyClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/faculties")
    List<Faculty> getFaculties();
}
