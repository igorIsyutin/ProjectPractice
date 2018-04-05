package com.kpi.lab.cafedra;

import com.kpi.lab.faculty.Faculty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cathedra {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer faculty_id;
//    private Faculty faculty;
}
