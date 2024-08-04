package tup.bibliotecasteam.services;

import org.springframework.stereotype.Service;
import tup.bibliotecasteam.dtos.JuegoHorasDto;
import tup.bibliotecasteam.dtos.ReviewJuegoDto;
import tup.bibliotecasteam.models.Juego;

import java.util.List;

@Service
public interface JuegoService {
    Juego findByNombre(String nombre);
    List<Juego> getAllByNombreGenero(String genero);

    //1. "Juegos que tengan ..."
    List<Juego> juegosQueTengan(String palabra);

    //2. "Listar juegos con su cantidad total de reviews"
    List<ReviewJuegoDto> juegosCountReviews();

    //3 "Listar juegos por cantidad total de horas jugadas"
    List<JuegoHorasDto> juegosConHorasTotales();
}
