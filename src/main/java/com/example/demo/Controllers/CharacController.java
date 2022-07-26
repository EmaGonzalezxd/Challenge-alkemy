package com.example.demo.Controllers;

import com.example.demo.DTOS.CharacDTO;
import com.example.demo.DTOS.GenreDTO;
import com.example.demo.Services.CharacService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacController {

    @Autowired
    private CharacService characService;

    //Crear personaje
    @PostMapping
    public ResponseEntity<CharacDTO> save(@RequestBody CharacDTO characDTO,
            @RequestParam(value = "loadMovies", required = false) boolean loadMovies) {
        CharacDTO characSaved = characService.save(characDTO, loadMovies);
        return ResponseEntity.status(HttpStatus.CREATED).body(characSaved);
    }

//   Mostrar personaje
    @GetMapping
    public ResponseEntity<List<CharacDTO>> getAll(@RequestParam(value = "loadMovies", required = false) boolean loadMovies) {
        List<CharacDTO> characDTOList = characService.getAll(loadMovies);
        return ResponseEntity.ok().body(characDTOList);
    }

//  Modificar personajes segun su id
    @PutMapping("/{id}")
    public ResponseEntity<CharacDTO> update(@PathVariable Long id,
            @RequestBody CharacDTO characDTO,
            @RequestParam(value = "loadMovies", required = false) boolean loadMovies) {
        CharacDTO characUpdate = characService.update(id, characDTO, loadMovies);
        return ResponseEntity.ok().body(characUpdate);
    }

//  eliminar personaje
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        characService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
