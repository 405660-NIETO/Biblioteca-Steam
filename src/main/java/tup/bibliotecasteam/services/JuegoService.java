package tup.bibliotecasteam.services;

import org.springframework.stereotype.Service;
import tup.bibliotecasteam.models.Juego;
import tup.bibliotecasteam.dtos.JuegoDTO;

import java.util.List;

@Service
public interface JuegoService {
    Juego findByNombre(String nombre);
    List<Juego> getAllByNombreGenero(String genero);

    //1. "Juegos que tengan ..."
    List<Juego> juegosQueTengan(String palabra);
    //2 Juegos por cantidad de review descendente
    List<JuegoDTO> juegosPorReviewAscendente();


}
