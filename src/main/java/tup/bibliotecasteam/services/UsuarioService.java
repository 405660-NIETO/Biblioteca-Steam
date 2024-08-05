package tup.bibliotecasteam.services;

import org.springframework.stereotype.Service;
import tup.bibliotecasteam.dtos.UsuarioBibliotecaDto;
import tup.bibliotecasteam.dtos.UsuariosHorasTotalesDto;
import tup.bibliotecasteam.models.Usuario;

import java.util.List;


@Service
public interface UsuarioService {
    Usuario findByEmailAndPassword(String email, String password);

    //Punto 5
    List<UsuarioBibliotecaDto> usuariosConCantidadJuegos();

    //Punto 6
    List<UsuariosHorasTotalesDto> usuariosPorTotalHoras();

    //Punto 7
    List<Usuario> findUsuariosPorJuego(String juego);
}
