package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tup.bibliotecasteam.dtos.JuegoHorasDto;
import tup.bibliotecasteam.dtos.JuegosDescargadosDto;
import tup.bibliotecasteam.dtos.ReviewJuegoDto;
import tup.bibliotecasteam.entities.JuegoEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface JuegoJpaRepository extends JpaRepository<JuegoEntity, Long> {
    Optional<JuegoEntity> findByNombre(String nombre);

    @Query("SELECT j FROM JuegoEntity j JOIN GeneroEntity g ON j.genero.id = g.id WHERE g.nombre = :genero")
    Optional<List<JuegoEntity>> getAllByNombreGenero(@Param("genero") String genero);

    //Punto 1
    @Query("SELECT j FROM JuegoEntity j JOIN j.genero g WHERE LOWER(j.nombre) LIKE LOWER(CONCAT('%', :palabra, '%'))")
    Optional<List<JuegoEntity>> getAllJuegosLike(@Param("palabra") String palabra);

    //Punto 2
    @Query("SELECT new " +
            "tup.bibliotecasteam.dtos.ReviewJuegoDto(j.id, j.nombre, COUNT(b.review)) " +
            "FROM JuegoEntity j " +
            "LEFT JOIN BibliotecaEntity b ON j.id = b.juego.id " +
            "GROUP BY j.id, j.nombre")
    List<ReviewJuegoDto> findJuegosWithReviewCount();

    //Punto 3
    @Query("SELECT new tup.bibliotecasteam.dtos.JuegoHorasDto(j.nombre, SUM(b.horas)) " +
            "FROM JuegoEntity j " +
            "LEFT JOIN BibliotecaEntity b ON j.id = b.juego.id " +
            "GROUP BY j.nombre " +
            "ORDER BY SUM(b.horas) DESC")
    List<JuegoHorasDto> getJuegosConHorasTotales();

    //Punto 4
    @Query("SELECT new tup.bibliotecasteam.dtos.JuegosDescargadosDto(j.nombre, COUNT(b.usuario.id)) " +
            "FROM JuegoEntity j " +
            "LEFT JOIN BibliotecaEntity b ON j.id = b.juego.id " +
            "GROUP BY j.nombre " +
            "ORDER BY COUNT(b.usuario.id) DESC")
    List<JuegosDescargadosDto> findJuegosConTotalDescargas();
}

