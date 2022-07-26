package com.example.demo.Services.impl;

import com.example.demo.DTOS.MovieDTO;
import com.example.demo.Mappers.MovieMapper;
import com.example.demo.Models.Charac;
import com.example.demo.Models.Movie;
import com.example.demo.Repositories.CharacRepository;
import com.example.demo.Repositories.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class movieServiceimpl {

    @Autowired
    MovieMapper movieMapper;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CharacRepository characRepository;

//  Crud
// Crear peli(Guardar)
    public MovieDTO save(MovieDTO movieDTO, boolean loadCharacters) {
        Movie movie = movieRepository.save(movieMapper.movieDTOToEntity(movieDTO));
        return movieMapper.movieEntityToDTO(movie, loadCharacters);
    }

//  Mostrar todas las pelis de la db (Mostrar)
    public List<MovieDTO> getAll(boolean loadCharacters) {
        return movieMapper.movieEntityListToDTOList(movieRepository.findAll(), loadCharacters);
    }

//  Modificar pelis que haya en la db segun su id 
    public MovieDTO update(Long id, MovieDTO dto, boolean loadCharacters) {
        Movie movie = movieRepository.findById(id).get();
        movie.setTitle(dto.getTitle());
        movie.setPicture(dto.getPicture());
        movie.setGenres(dto.getGenres());
        List<Charac> characList = new ArrayList<>();
        for (Long idCharacs : dto.getCharacters()) {
            characList.add(characRepository.findById(id).get());
        }
        movie.setCharacters(characList);
        movie.setScore(dto.getScore());
        movie.setCreationDate(dto.getCreationDate());

        return movieMapper.movieEntityToDTO(movieRepository.save(movie), loadCharacters);
    }

//   Eliminar peliculas suegun su id
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

//  Agregar personaje a la peli
    public MovieDTO addCharacter(Long idMovie, List<Long> idCharacters, boolean loadCharacters) throws Exception {

        Movie movie = movieRepository
                .findById(idMovie)
                .orElseThrow(() -> new Exception("Movie not found"));

        List<Charac> charactersFromRequest = characRepository.findAllById(idCharacters);
        List<Charac> charactersFromMovie = movie.getCharacters();
        List<Charac> concatLists = Stream
                .concat(charactersFromMovie.stream(), charactersFromRequest.stream())
                .collect(Collectors.toList());

        movie.setCharacters(concatLists);
        movieRepository.save(movie);
        return movieMapper.movieEntityToDTO(movie, loadCharacters);
    }
}
