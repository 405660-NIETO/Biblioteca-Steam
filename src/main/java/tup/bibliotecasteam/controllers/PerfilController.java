package tup.bibliotecasteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tup.bibliotecasteam.models.Perfil;
import tup.bibliotecasteam.services.PerfilService;

import java.util.List;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/get")
    public ResponseEntity<List<Perfil>> getAllPerfiles() {
        List<Perfil> perfiles = perfilService.getAllPerfiles();
        return ResponseEntity.ok(perfiles);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Perfil> getPerfilById(@PathVariable Long id) {
        Perfil perfil = perfilService.getPerfilById(id);
        return ResponseEntity.ok(perfil);
    }
}
