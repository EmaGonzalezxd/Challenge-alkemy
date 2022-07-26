package com.example.demo.Repositories;

import com.example.demo.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenreRepository extends JpaRepository<Genre, Long>{
    
}
