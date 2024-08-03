package tup.bibliotecasteam.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tup.bibliotecasteam.entities.UsuarioEntity;
import tup.bibliotecasteam.models.Usuario;
import tup.bibliotecasteam.repository.UsuarioJpaRepository;
import tup.bibliotecasteam.services.UsuarioService;

import java.time.LocalDateTime;
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
}
