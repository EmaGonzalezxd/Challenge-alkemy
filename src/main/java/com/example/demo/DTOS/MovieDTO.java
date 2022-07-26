package com.example.demo.DTOS;


import com.example.demo.Models.Genre;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String picture;
    private String title;
    private LocalDate creationDate;
    private Integer score;
    private List<Long> characters;
    private List<CharacDTO> charactersResponse;
    private List<Genre> genres;

}
