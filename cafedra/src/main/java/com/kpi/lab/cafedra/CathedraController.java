package com.kpi.lab.cafedra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CathedraController {

    @Autowired
    private CathedraService cathedraService;

    @GetMapping("/")
    public String map(){
        return "<a href=\"/api/cathedras\">/api/cathedras</a> + " +
                "<br />" +
                "<a href=\"/api/cathedras/1\">/api/cathedras/{id}</a>";
    }

    @GetMapping("/api/cathedras")
    public String getFaculties(){
        return cathedraService.getAll().toString();
    }

    @GetMapping("/api/cathedras/{id}")
    public String getFaculty(@PathVariable Integer id){
        return cathedraService.getById(id).toString();
    }

    @PostMapping("/api/cathedra")
    public String createFaculty(@RequestBody Cathedra cathedra){
        return cathedraService.create(cathedra);
    }
}
