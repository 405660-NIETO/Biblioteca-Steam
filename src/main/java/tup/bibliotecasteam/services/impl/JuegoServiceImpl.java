package tup.bibliotecasteam.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tup.bibliotecasteam.entities.JuegoEntity;
import tup.bibliotecasteam.models.Juego;
import tup.bibliotecasteam.repository.JuegoJpaRepository;
import tup.bibliotecasteam.services.JuegoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JuegoServiceImpl implements JuegoService {

    @Autowired
    private JuegoJpaRepository juegoJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Juego findByNombre(String nombre) {
        Optional<JuegoEntity> juegoEntity = juegoJpaRepository.findByNombre(nombre);
        if (juegoEntity.isEmpty()){
            throw new EntityNotFoundException("Juego no encontrado!");
        }
        return modelMapper.map(juegoEntity, Juego.class);
    }

    @Override
    public List<Juego> getAllByNombreGenero(String genero) {
        List<Juego> listJuegos = new ArrayList<>();
        Optional<List<JuegoEntity>> juegoEntityList = juegoJpaRepository.getAllByNombreGenero(genero);
        juegoEntityList.ifPresent(list -> list.forEach(
                juegoEntity -> listJuegos.add(modelMapper.map(juegoEntity, Juego.class))
        ));
        /*
        for (JuegoEntity juegoEntity : juegoEntityList.get()) {
            listJuegos.add(modelMapper.map(juegoEntity, Juego.class));
        }
        */
        if (listJuegos.isEmpty()){
            throw new EntityNotFoundException("Ningun juego encontrado!");
        }
        return listJuegos;
    }

    // Punto 1
    @Override
    public List<Juego> juegosQueTengan(String palabra) {
        List<Juego> listaJuego = new ArrayList<>();
        Optional<List<JuegoEntity>> entityList = juegoJpaRepository.getAllJuegosLike(palabra);
        entityList.ifPresent(list -> list.forEach(
                entity -> listaJuego.add(modelMapper.map(entity, Juego.class))
        ));
        if (listaJuego.isEmpty()){
            throw new EntityNotFoundException("No se encontraron coincidencias!");
        }
        return listaJuego;
    }
}
