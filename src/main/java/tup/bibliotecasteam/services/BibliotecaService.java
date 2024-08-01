package tup.bibliotecasteam.services;

import org.springframework.stereotype.Service;
import tup.bibliotecasteam.models.Biblioteca;
import tup.bibliotecasteam.models.Juego;
import tup.bibliotecasteam.models.Usuario;

import java.util.List;

@Service
public interface BibliotecaService {
    List<Biblioteca> findAllByUsuario(Usuario usuario);
    List<Biblioteca> findAllByJuego(Juego juego);
    List<Biblioteca> findByHoras(Integer minimoHoras);
}
