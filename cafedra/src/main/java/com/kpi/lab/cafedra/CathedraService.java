package com.kpi.lab.cafedra;
import com.kpi.lab.faculty.Faculty;
import com.kpi.lab.faculty.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

public interface CathedraService {
//    static {
//        Faculty faculty1 = new Faculty(1, "FICT", "The best!");
//        Faculty faculty2 = new Faculty(2, "FT", "All girls here!");
//        Faculty faculty3 = new Faculty(3, "FAS", "Sikorsky was here!");
//
//        Cathedra cathedra1 = new Cathedra(1, "TK", faculty1);
//        cathedras.put(1, cathedra1);
//        Cathedra cathedra2 = new Cathedra(2, "AUTS", faculty1);
//        cathedras.put(2, cathedra2);
//        Cathedra cathedra3 = new Cathedra(3, "EN", faculty2);
//        cathedras.put(3, cathedra3);
//    }

    public List<Cathedra> getList();

    public Cathedra createCathedra(String cathedraName, Integer facultyId);

    public Optional<Cathedra> getCathedra(Integer id);
}
