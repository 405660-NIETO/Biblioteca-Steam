package tup.bibliotecasteam.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tup.bibliotecasteam.entities.PerfilEntity;
import tup.bibliotecasteam.models.Perfil;
import tup.bibliotecasteam.repository.PerfilJpaRepository;
import tup.bibliotecasteam.services.PerfilService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilJpaRepository perfilJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Perfil> getAllPerfiles() {
        List<Perfil> perfiles = new ArrayList<>();
        List<PerfilEntity> entityList = perfilJpaRepository.findAll();
        entityList.forEach( entity -> perfiles.add(modelMapper.map(entity, Perfil.class)));
        if (perfiles.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron perfiles!");
        }
        return perfiles;
    }

    @Override
    public Perfil getPerfilById(Long id) {
        PerfilEntity entity = perfilJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Perfil no encontrado"));
        return modelMapper.map(entity, Perfil.class);
    }
}
