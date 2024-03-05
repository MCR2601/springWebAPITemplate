package com.ase.reiterer.entryTest;

import com.ase.reiterer.entryTest.data.SolutionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SolutionListRepostory extends JpaRepository<SolutionList,Integer> {
}
