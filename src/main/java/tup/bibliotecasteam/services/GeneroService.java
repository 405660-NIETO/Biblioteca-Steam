package tup.bibliotecasteam.services;

import org.springframework.stereotype.Service;
import tup.bibliotecasteam.models.Genero;

@Service
public interface GeneroService {
    Genero findByNombre(String nombre);
}
