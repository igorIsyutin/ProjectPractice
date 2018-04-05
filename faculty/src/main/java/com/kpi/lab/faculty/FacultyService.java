package com.kpi.lab.faculty;
import java.util.*;

public interface FacultyService {
    List<Faculty> getList();

    Optional<Faculty> getFaculty(Integer id);

    Faculty createFaculty(String nameFaculty, String descriptionFaculty);

    //Faculty updateFaculty(Integer id, Faculty updatedFaculty);
}
