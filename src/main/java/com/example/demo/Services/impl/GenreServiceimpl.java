package com.example.demo.Services.impl;

import com.example.demo.DTOS.GenreDTO;
import com.example.demo.Mappers.GenreMapper;
import com.example.demo.Models.Genre;
import com.example.demo.Repositories.GenreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class GenreServiceimpl {
    
        @Autowired
    GenreRepository genreRepository;

    @Autowired
    GenreMapper genreMapper;

//   Metodos crud

//   Crear Genero (guardado)
    public GenreDTO save(GenreDTO dto) {
        Genre genre = genreRepository.save(genreMapper.genreDTOToEntity(dto));
        return genreMapper.genreEntityToDTO(genre);
    }

//  Mostrar generos que hay en la db (mostrado)
    public List<GenreDTO> getAll() {
        return genreMapper.genreEntityListToDTOList(genreRepository.findAll());
    }

//  Modificar generos segun su id (modificacion)
    public GenreDTO update(Long id, GenreDTO dto) {
        Genre genre = genreRepository.findById(id).get();
        genre.setName(dto.getName());
        genre.setPicture(dto.getPicture());

        return genreMapper.genreEntityToDTO(genreRepository.save(genre));
    }

//  Eliminar generos segun su id (eliminacion)
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
