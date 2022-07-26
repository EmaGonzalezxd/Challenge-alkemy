package com.example.demo.Mappers;

import com.example.demo.DTOS.CharacDTO;
import com.example.demo.DTOS.MovieBasicDTO;
import com.example.demo.DTOS.MovieDTO;
import com.example.demo.Models.Charac;
import com.example.demo.Models.Movie;
import com.example.demo.Repositories.CharacRepository;
import com.example.demo.Repositories.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    @Autowired
    @Lazy
    CharacMapper characMapper;
    @Autowired
    CharacRepository characRepository;
    @Autowired
    MovieRepository movieRepository;

    public Movie movieDTOToEntity(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setPicture(movieDTO.getPicture());
        movie.setCreationDate(movieDTO.getCreationDate());
        movie.setScore(movieDTO.getScore());
        List<Charac> characs = new ArrayList<>();
        if (movieDTO.getCharacters() != null) {
            for (Long id : movieDTO.getCharacters()) {
                characs.add(characRepository.findById(id).get());
            }
            movie.setCharacters(characs);
        }

        movie.setGenres(movieDTO.getGenres());

        return movie;
    }

    public MovieDTO movieEntityToDTO(Movie movie, boolean loadCharacters) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setPicture(movie.getPicture());
        movieDTO.setCreationDate(movie.getCreationDate());
        movieDTO.setScore(movie.getScore());
        movieDTO.setGenres(movie.getGenres());
        if (loadCharacters) {
            List<CharacDTO> characDTOList = new ArrayList<>();
            for (Charac charac :
                    movie.getCharacters()) {
                characDTOList.add(characMapper.characEntityToDTO(charac, false));
            }
            movieDTO.setCharactersResponse(characDTOList);
        }

        return movieDTO;
    }

    public List<MovieDTO> movieEntityListToDTOList(List<Movie> movieList, boolean loadCharacters) {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for (Movie movie : movieList) {
            movieDTOList.add(movieEntityToDTO(movie, loadCharacters));
        }
        return movieDTOList;
    }

    public List<MovieBasicDTO> movieEntityListToCharacBasicDTOList(List<Movie> movies) {
        List<MovieBasicDTO> movieBasicDTOs = new ArrayList<>();
        MovieBasicDTO basicDTO;
        for (Movie movie : movies) {
            basicDTO = new MovieBasicDTO();
            basicDTO.setId(movie.getId());
            basicDTO.setTitle(movie.getTitle());
            basicDTO.setPicture(movie.getPicture());
            movieBasicDTOs.add(basicDTO);
        }
        return movieBasicDTOs;
    }
}
