package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tup.bibliotecasteam.entities.JuegoEntity;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

@Repository
public interface JuegoJpaRepository extends JpaRepository<JuegoEntity, Long> {
    Optional<JuegoEntity> findByNombre(String nombre);

    @Query("SELECT j FROM JuegoEntity j JOIN GeneroEntity g ON j.genero.id = g.id WHERE g.nombre = :genero")
    Optional<List<JuegoEntity>> getAllByNombreGenero(@Param("genero") String genero);

    //@Query("SELECT j FROM JuegoEntity j JOIN j.genero g WHERE j.nombre LIKE CONCAT('%', :palabra, '%')")
    @Query("SELECT j FROM JuegoEntity j JOIN j.genero g WHERE LOWER(j.nombre) LIKE LOWER(CONCAT('%', :palabra, '%'))")
    Optional<List<JuegoEntity>> getAllJuegosLike(@Param("palabra") String palabra);



}
