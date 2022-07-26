package com.example.demo.Services.impl;

import com.example.demo.DTOS.CharacDTO;
import com.example.demo.Mappers.CharacMapper;
import com.example.demo.Models.Charac;
import com.example.demo.Repositories.CharacRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacServiceimpl {

    @Autowired
    private CharacMapper characMapper;
    @Autowired
    private CharacRepository characRepository;

//  metodos crud

//  Crear personajes (guardar)
    public CharacDTO save(CharacDTO characDTO, boolean loadMovies) {
        Charac charac = characRepository.save(characMapper.characDTOToEntity(characDTO));
        return characMapper.characEntityToDTO(charac, loadMovies);
    }

//  Mostrar los personajes haya en la db (mostar)
    public List<CharacDTO> getAll(boolean loadMovies) {
        return characMapper.characEntityListToDTOList(characRepository.findAll(), loadMovies);
    }

//  Modificar personajes segun su id (modificar)
    public CharacDTO update(Long id, CharacDTO dto, boolean loadMovies) {
        Charac charac = characRepository.findById(id).get();
        charac.setAge(dto.getAge());
        charac.setName(dto.getName());
        charac.setPicture(dto.getPicture());
        charac.setStory(dto.getStory());
        charac.setWeight(dto.getWeight());
        return characMapper.characEntityToDTO(characRepository.save(charac), loadMovies);
    }

//   Eliminar personajes segun su id (eliminar)
    public void delete(Long id) {
        characRepository.deleteById(id);
    }
}
