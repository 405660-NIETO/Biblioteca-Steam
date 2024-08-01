package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tup.bibliotecasteam.entities.BibliotecaEntity;
import tup.bibliotecasteam.entities.JuegoEntity;
import tup.bibliotecasteam.entities.UsuarioEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface BibliotecaJpaRepository extends JpaRepository<BibliotecaEntity, Long> {
    Optional<List<BibliotecaEntity>> findAllByUsuario(UsuarioEntity usuario);
    Optional<List<BibliotecaEntity>> findAllByJuego(JuegoEntity juego);


    //ver juegos que jugue por una cantidad mayor de horas x
    Optional<List<BibliotecaEntity>> findAllByHorasGreaterThanEqual(Integer minimoHoras);
}
