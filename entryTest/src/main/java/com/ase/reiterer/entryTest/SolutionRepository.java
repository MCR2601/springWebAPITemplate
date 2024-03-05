package com.ase.reiterer.entryTest;

import com.ase.reiterer.entryTest.data.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SolutionRepository extends JpaRepository<Solution,Integer> {
}
