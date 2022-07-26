package com.example.demo.Repositories;

import com.example.demo.Models.Charac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacRepository extends JpaRepository<Charac, Long> {
    
}
