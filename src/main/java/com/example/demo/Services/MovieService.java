package com.example.demo.Services;

import com.example.demo.DTOS.MovieDTO;
import java.util.List;

public interface MovieService {

//    Creación, Edición y Eliminación de Pelicula (CRUD)
//    Guardar Pelicula en la db
    MovieDTO save(MovieDTO movieDTO, boolean loadCharacters);

//    Traer todos las pelis que hay en la db
    List<MovieDTO> getAll(boolean loadCharacters);

//    Modificar las pelis de la db segun el ID
    MovieDTO update(Long id, MovieDTO dto, boolean loadCharacters);

//    Eliminar pelis de la db sugun el ID
    void delete(Long id);

//   Añadir personajes a pelis
    MovieDTO addCharacter(Long idMovie, List<Long> idCharacters, boolean loadCharacters) throws Exception;

}
