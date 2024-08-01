package tup.bibliotecasteam.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tup.bibliotecasteam.entities.GeneroEntity;
import tup.bibliotecasteam.models.Genero;
import tup.bibliotecasteam.repository.GeneroJpaRepository;
import tup.bibliotecasteam.services.GeneroService;

import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroJpaRepository generoJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Genero findByNombre(String nombre) {
        Optional<GeneroEntity> generoEntity = generoJpaRepository.findByNombre(nombre);
        if (generoEntity.isEmpty()){
            throw new EntityNotFoundException("Genero no encontrado!");
        }
        return modelMapper.map(generoEntity.get(),Genero.class);
    }
}
