package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    //Trae los juegos que tienen review no nula ni empty string
    //Le tuve q poner order by id asc para ajustarse a la logica iterativa del contador en el servicio
    @Query("SELECT b FROM BibliotecaEntity b WHERE b.review IS NOT NULL AND b.review <> '' " +
            "ORDER BY b.juego.id ASC")
    Optional<List<BibliotecaEntity>> getBibliotecasPerReview();
}
