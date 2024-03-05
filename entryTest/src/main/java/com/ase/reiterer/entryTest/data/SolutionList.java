package com.ase.reiterer.entryTest.data;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SolutionList")
public class SolutionList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    private Set<Solution> solutions = new HashSet<>();


    public SolutionList(){}


    public SolutionList(Set<Solution> solutions){
        this.solutions = solutions;
    }

    public Integer getId() {
        return id;
    }

    public Set<Solution> getSolutions() {
        return solutions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSolutions(Set<Solution> solutions) {
        this.solutions = solutions;
    }
}
