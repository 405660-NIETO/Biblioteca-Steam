package tup.bibliotecasteam.services;

import org.springframework.stereotype.Service;
import tup.bibliotecasteam.dtos.UsuarioBibliotecaDto;
import tup.bibliotecasteam.dtos.UsuarioXLogros;
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

    //Punto 8
    List<UsuarioXLogros> findUsuariosXLogros();

    //Punto 9
    List<Usuario> findHighLevelUsuarios();

    //Punto 10
    List<Usuario> findUsuariosRecientes();

    //Punto 11
    List<Usuario> findUsuarioAntiguo();
}
