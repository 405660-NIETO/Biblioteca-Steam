package tup.bibliotecasteam.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tup.bibliotecasteam.dtos.UsuarioBibliotecaDto;
import tup.bibliotecasteam.dtos.UsuarioXLogros;
import tup.bibliotecasteam.dtos.UsuariosHorasTotalesDto;
import tup.bibliotecasteam.entities.UsuarioEntity;
import tup.bibliotecasteam.models.Usuario;
import tup.bibliotecasteam.repository.UsuarioJpaRepository;
import tup.bibliotecasteam.services.UsuarioService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Usuario findByEmailAndPassword(String email, String password) {
        Optional<UsuarioEntity> usuarioEntity = usuarioJpaRepository.findByEmailAndPassword(email, password);
        if (usuarioEntity.isEmpty()){
            throw new EntityNotFoundException("El email y la password no son reconocidas!");
        }
        //le actualizo el last y lo guardo
        usuarioEntity.get().setLastLogin(LocalDateTime.now());
        usuarioJpaRepository.save(usuarioEntity.get());
        //usuarioJpaRepository.updateLastLogin(email);
        return modelMapper.map(usuarioEntity.get(), Usuario.class);
    }

    @Override
    public List<UsuarioBibliotecaDto> usuariosConCantidadJuegos() {
        List<UsuarioBibliotecaDto> listaUsuarios = usuarioJpaRepository.findUsuariosXCantidadJuegos();
        if (listaUsuarios.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron usuarios con juegos comprados.");
        }
        return listaUsuarios;
    }

    @Override
    public List<UsuariosHorasTotalesDto> usuariosPorTotalHoras() {
        List<UsuariosHorasTotalesDto> listaUsuarios = usuarioJpaRepository.findUsuariosXHorasTotales();
        if (listaUsuarios.isEmpty()) {
            throw new EntityNotFoundException("No hay usuarios con horas registradas.");
        }
        return listaUsuarios;
    }

    @Override
    public List<Usuario> findUsuariosPorJuego(String juego) {
        List<Usuario> usuarios = new ArrayList<>();
        Optional<List<UsuarioEntity>> listEntity = usuarioJpaRepository.findUsuariosPorJuego(juego);
        listEntity.ifPresent(entidades -> entidades.forEach(
                entity -> usuarios.add(modelMapper.map(entity, Usuario.class))
        ));
        if (usuarios.isEmpty()) {
            throw new EntityNotFoundException("Ese juego no se encuentra en la biblioteca de ningún usuario!");
        }
        return usuarios;
    }

    @Override
    public List<UsuarioXLogros> findUsuariosXLogros() {
        List<UsuarioXLogros> listaUsuarios = usuarioJpaRepository.findUsuariosXLogros();
        if (listaUsuarios.isEmpty()) {
            throw new EntityNotFoundException("Aun no hay usuarios con logros!");
        }
        return listaUsuarios;
    }

    @Override
    public List<Usuario> findHighLevelUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Optional<List<UsuarioEntity>> optionalList = usuarioJpaRepository.findHighLevelUsuarios();
        optionalList.ifPresent(entidades -> entidades.forEach(
                entidad -> usuarios.add(modelMapper.map(entidad, Usuario.class))
        ));
        if (usuarios.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron usuarios!");
        }
        return usuarios;
    }

    @Override
    public List<Usuario> findUsuariosRecientes() {
        List<Usuario> usuarios = new ArrayList<>();
        Optional<List<UsuarioEntity>> optionalList = usuarioJpaRepository.findUsuariosRecientes();
        optionalList.ifPresent(entidades -> entidades.forEach(
                entidad -> usuarios.add(modelMapper.map(entidad, Usuario.class))
        ));
        if (usuarios.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron usuarios!");
        }
        return usuarios;
    }

    @Override
    public List<Usuario> findUsuarioAntiguo() {
        List<Usuario> usuarios = new ArrayList<>();
        Optional<List<UsuarioEntity>> optionalList = usuarioJpaRepository.findUsuarioAntiguo();
        optionalList.ifPresent(entidades -> entidades.forEach(
                entidad -> usuarios.add(modelMapper.map(entidad, Usuario.class))
        ));
        if (usuarios.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron usuarios!");
        }
        return usuarios;
    }
}
