package com.ase.reiterer.entryTest.controllers;

import com.ase.reiterer.entryTest.SolutionListRepostory;
import com.ase.reiterer.entryTest.SolutionRepository;
import com.ase.reiterer.entryTest.data.Solution;
import com.ase.reiterer.entryTest.data.SolutionList;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "")
public class SolutionController {

    private final SolutionRepository solutionRepository;
    private final SolutionListRepostory solutionListRepostory;


    public SolutionController(SolutionRepository solutionRepository, SolutionListRepostory solutionListRepostory) {
        this.solutionRepository = solutionRepository;
        this.solutionListRepostory = solutionListRepostory;
    }
    @GetMapping("/all")
    public Iterable<Solution> getAllSolutions(){
        return this.solutionRepository.findAll();
    }

    @GetMapping("/allList")
    public Iterable<SolutionList> getAllSolutionLists(){

        List<SolutionList> all = this.solutionListRepostory.findAll();

        for (SolutionList s :
                all) {
            System.out.println(s.getSolutions().size());
        }

        return all;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Solution addSolution(@RequestBody Solution solution){
        return this.solutionRepository.save(new Solution(solution.getName(),solution.getCost(),solution.getDetails()));
    }


    @PostMapping("/addList")
    @ResponseStatus(HttpStatus.CREATED)
    public SolutionList addSolutionList(@RequestBody SolutionList list){
        SolutionList l = new SolutionList(list.getSolutions().stream().map(s ->this.solutionRepository.findById(s.getId()).get()).collect(Collectors.toSet()));

        l.getSolutions().stream().forEach(s -> s.setList(l));

        return this.solutionListRepostory.saveAndFlush(l);
    }

}
