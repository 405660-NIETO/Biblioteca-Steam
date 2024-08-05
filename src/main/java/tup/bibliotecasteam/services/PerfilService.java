package tup.bibliotecasteam.services;

import org.springframework.stereotype.Service;
import tup.bibliotecasteam.models.Perfil;

import java.util.List;

@Service
public interface PerfilService {
    List<Perfil> getAllPerfiles();
    Perfil getPerfilById(Long id);
}
