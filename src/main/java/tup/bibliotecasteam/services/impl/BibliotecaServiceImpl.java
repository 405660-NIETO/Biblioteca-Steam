package tup.bibliotecasteam.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tup.bibliotecasteam.entities.BibliotecaEntity;
import tup.bibliotecasteam.entities.JuegoEntity;
import tup.bibliotecasteam.entities.UsuarioEntity;
import tup.bibliotecasteam.models.Biblioteca;
import tup.bibliotecasteam.models.Juego;
import tup.bibliotecasteam.models.Usuario;
import tup.bibliotecasteam.repository.BibliotecaJpaRepository;
import tup.bibliotecasteam.services.BibliotecaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaServiceImpl implements BibliotecaService {

    @Autowired
    private BibliotecaJpaRepository bibliotecaJpaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<Biblioteca> findAllByUsuario(Usuario usuario) {
        List<Biblioteca> bibliotecas = new ArrayList<>();
        Optional<List<BibliotecaEntity>> bibliotecasEntityList = bibliotecaJpaRepository
                .findAllByUsuario(modelMapper.map(usuario, UsuarioEntity.class));

        bibliotecasEntityList.ifPresent(list -> list.forEach(
                bibliotecaEntity -> bibliotecas.add(modelMapper.map(bibliotecaEntity, Biblioteca.class))
        ));
        if (bibliotecas.isEmpty()){
            throw new  EntityNotFoundException("No se encontraron Bibliotecas de ese Usuario!");
        }
        return bibliotecas;
    }

    @Override
    public List<Biblioteca> findAllByJuego(Juego juego) {
        List<Biblioteca> bibliotecas = new ArrayList<>();
        Optional<List<BibliotecaEntity>> bibliotecasEntityList = bibliotecaJpaRepository
                .findAllByJuego(modelMapper.map(juego, JuegoEntity.class));
        bibliotecasEntityList.ifPresent(list -> list.forEach(
                bibliotecaEntity -> bibliotecas.add(modelMapper.map(bibliotecaEntity, Biblioteca.class))
        ));
        if (bibliotecas.isEmpty()){
            throw new  EntityNotFoundException("No se encontraron Bibliotecas con ese Juego!");
        }
        return bibliotecas;
    }

    @Override
    public List<Biblioteca> findByHoras(Integer minimoHoras) {
        List<Biblioteca> bibliotecas = new ArrayList<>();
        Optional<List<BibliotecaEntity>> bibliotecasEntityList = bibliotecaJpaRepository.findAllByHorasGreaterThanEqual(minimoHoras);
        bibliotecasEntityList.ifPresent(list -> list.forEach(
                bibliotecaEntity -> bibliotecas.add(modelMapper.map(bibliotecaEntity, Biblioteca.class))
        ));
        if (bibliotecas.isEmpty()){
            throw new  EntityNotFoundException("Ninguna biblioteca encontrada!");
        }
        return bibliotecas;
    }
}
