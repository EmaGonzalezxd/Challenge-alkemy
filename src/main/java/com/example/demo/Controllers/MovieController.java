package com.example.demo.Controllers;

import com.example.demo.DTOS.MovieDTO;
import com.example.demo.Services.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

//  Metodos crud
    
//  Crear peliculas
    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO,
            @RequestParam(value = "loadCharacters", required = false) boolean loadCharacters) {
        MovieDTO movieSaved = movieService.save(movieDTO, loadCharacters);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved);
    }

//  Mostrar todas las peliculas 
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll(@RequestParam(value = "loadCharacters", required = false) boolean loadCharacters) {
        List<MovieDTO> movieDTOList = movieService.getAll(loadCharacters);
        return ResponseEntity.ok().body(movieDTOList);
    }

//  Modificar Peli por su id
    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id,
            @RequestBody MovieDTO movieDTO,
            @RequestParam(value = "loadCharacters", required = false) boolean loadCharacters) {
        MovieDTO movieUpdated = movieService.update(id, movieDTO, loadCharacters);
        return ResponseEntity.ok().body(movieUpdated);
    }

//  Eliminar Peli por si  id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

// Agregar personajes a la peli
    @PutMapping("/{movieId}/character")
    public ResponseEntity<MovieDTO> addCharacter(@PathVariable Long movieId,
            @RequestBody MovieDTO movieDTO,
            @RequestParam(value = "loadCharacters", required = false) boolean loadCharacters) throws Exception {
        MovieDTO movieResponse = movieService.addCharacter(movieId, movieDTO.getCharacters(), loadCharacters);
        return ResponseEntity.ok().body(movieResponse);
    }

}
