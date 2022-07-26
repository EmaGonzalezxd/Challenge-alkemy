package com.example.demo.Services;

import com.example.demo.DTOS.CharacDTO;
import java.util.List;

public interface CharacService {

//    Creación, Edición y Eliminación de Personajes (CRUD)
    
//    Guardar personaje
    CharacDTO save(CharacDTO dto, boolean loadMovies);

//    Traer todos los personajes que hay en la db
    List<CharacDTO> getAll(boolean loadMovies);

//    Modificar los personajes de la db segun el ID
    CharacDTO update(Long id, CharacDTO dto, boolean loadMovies);

//    Eliminar personaje de la db sugun el ID
    void delete(Long id);
}
