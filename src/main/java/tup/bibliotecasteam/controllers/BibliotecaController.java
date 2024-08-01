package tup.bibliotecasteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tup.bibliotecasteam.models.Biblioteca;
import tup.bibliotecasteam.services.BibliotecaService;

import java.util.List;

@RestController
@RequestMapping("/bibliotecas")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping("/{horas}/")
    public ResponseEntity<List<Biblioteca>> findByHoras(@PathVariable Integer horas){
        List<Biblioteca> bibliotecas = bibliotecaService.findByHoras(horas);
        return ResponseEntity.ok(bibliotecas);
    }

    /*
       @GetMapping("/{nombre}/")
    public ResponseEntity<Juego> getJuegosByNombre(@PathVariable String nombre) {
        Juego juego = juegoService.findByNombre(nombre);
        return ResponseEntity.ok(juego);
    }
     */
}
