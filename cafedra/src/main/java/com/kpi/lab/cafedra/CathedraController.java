package com.kpi.lab.cafedra;

import com.kpi.lab.faculty.Faculty;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public List<Cathedra> getCathedras(){
        return cathedraService.getList();
    }

    @GetMapping("/api/cathedras/{id}")
    public Cathedra getCathedra(@PathVariable Integer id){
        return cathedraService.getCathedra(id).get();
    }

    @PostMapping("/api/cathedras")
    public ResponseEntity createCathedra(@RequestBody Cathedra newCathedra, HttpServletRequest servletRequest){
        Cathedra cathedra = cathedraService.createCathedra(newCathedra.getName(), newCathedra.getFaculty_id());
        URI uri = ServletUriComponentsBuilder.fromServletMapping(servletRequest)
                .path("/api/cathedras/{id}")
                .buildAndExpand(cathedra.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
