package com.example.demo.Controllers;

import com.example.demo.DTOS.GenreDTO;
import com.example.demo.Services.GenreService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    //Resgistrar generos
    @PostMapping
    public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genreDTO) {
        GenreDTO genreSaved = genreService.save(genreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreSaved);
    }

    //Mostrar todos los generos
    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAll() {
        List<GenreDTO> genreDTOList = genreService.getAll();
        return ResponseEntity.ok().body(genreDTOList);
    }

    //Modificar generos segun id
    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> update(@PathVariable Long id,
            @RequestBody GenreDTO genreDTO) {
        GenreDTO genreUpdated = genreService.update(id, genreDTO);
        return ResponseEntity.ok().body(genreUpdated);
    }

    //Eliminar generos segun su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        genreService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
