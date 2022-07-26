package com.example.demo.Services;

import com.example.demo.DTOS.GenreDTO;
import java.util.List;

public interface GenreService {

//    Creación, Edición y Eliminación de Pelicula (CRUD)
//    Guardar Pelicula en la db
    GenreDTO save(GenreDTO dto);

//    Traer todos los generos que hay en la db
    List<GenreDTO> getAll();

//    Modificar los generos de la db segun el ID
    GenreDTO update(Long id, GenreDTO dto);

//    Eliminar generos de la db sugun el ID
    void delete(Long id);

    /*----------------*/
}
