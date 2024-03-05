package com.ase.reiterer.entryTest.data;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "solution")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer cost;

    private String details;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "solutionlist_id")
    @JsonBackReference
    private SolutionList list;

    public Solution(){}

    public Solution(String name, Integer cost, String details){
        this.name = name;
        this.cost = cost;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public String getDetails() {
        return details;
    }

    public SolutionList getList() {
        return list;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setList(SolutionList list) {
        this.list = list;
    }
}
