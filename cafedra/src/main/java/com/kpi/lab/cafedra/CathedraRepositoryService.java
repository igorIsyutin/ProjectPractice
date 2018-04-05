package com.kpi.lab.cafedra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CathedraRepositoryService implements CathedraService{

    @Autowired
    private CathedraRepository cathedraRepository;

    @Override
    public List<Cathedra> getList() {
        List<Cathedra> cathedraList = new ArrayList<>();
        cathedraRepository.findAll().forEach(cathedraList::add);
        return cathedraList;
    }

    @Override
    public Cathedra createCathedra(String cathedraName, Integer facultyId) {
        Cathedra newCathedra = Cathedra.builder().name(cathedraName).faculty_id(facultyId).build();
        return cathedraRepository.save(newCathedra);
    }

    @Override
    public Optional<Cathedra> getCathedra(Integer id) {
        return cathedraRepository.findById(id);
    }
}
