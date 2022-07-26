/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Mappers;

import com.example.demo.DTOS.GenreDTO;
import com.example.demo.Models.Genre;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {


    public Genre genreDTOToEntity(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setName(genreDTO.getName());
        genre.setPicture(genreDTO.getPicture());

        return genre;
    }


    public GenreDTO genreEntityToDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        genreDTO.setPicture(genre.getPicture());

        return genreDTO;
    }

    public List<GenreDTO> genreEntityListToDTOList(List<Genre> genreList){
        List<GenreDTO> genreDTOList = new ArrayList<>();
        for (Genre genre : genreList){
            genreDTOList.add(genreEntityToDTO(genre));
        }
        return genreDTOList;
    } 
}
