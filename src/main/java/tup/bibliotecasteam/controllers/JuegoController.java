package tup.bibliotecasteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tup.bibliotecasteam.models.Juego;
import tup.bibliotecasteam.services.JuegoService;
import tup.bibliotecasteam.dtos.JuegoDTO;

import java.util.List;

@RestController
@RequestMapping("/juegos")
public class JuegoController {

    @Autowired
    private JuegoService juegoService;

    @GetMapping("porReviews/ascendente")
    public ResponseEntity<List<JuegoDTO>> getJuegosPerReviewAsc() {
        return ResponseEntity.ok(juegoService.juegosPorReviewAscendente());
    }

    @GetMapping("/{nombre}/")
    public ResponseEntity<Juego> getJuegosByNombre(@PathVariable String nombre) {
        Juego juego = juegoService.findByNombre(nombre);
        return ResponseEntity.ok(juego);
    }

    @GetMapping("genero/{genero}/")
    public ResponseEntity<List<Juego>> getJuegosByGenero(@PathVariable String genero) {
        List<Juego> juegos = juegoService.getAllByNombreGenero(genero);
        return ResponseEntity.ok(juegos);
    }

    @GetMapping("buscar/{palabra}")
    public ResponseEntity<List<Juego>> buscar(@PathVariable String palabra) {
        return ResponseEntity.ok(juegoService.juegosQueTengan(palabra));
    }
}
