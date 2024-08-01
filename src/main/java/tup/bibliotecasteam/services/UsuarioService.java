package tup.bibliotecasteam.services;

import org.springframework.stereotype.Service;
import tup.bibliotecasteam.models.Usuario;


@Service
public interface UsuarioService {
    Usuario findByEmailAndPassword(String email, String password);
}
