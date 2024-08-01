package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tup.bibliotecasteam.entities.JuegoEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface JuegoJpaRepository extends JpaRepository<JuegoEntity, Long> {
    Optional<JuegoEntity> findByNombre(String nombre);

    @Query("SELECT j FROM JuegoEntity j JOIN GeneroEntity g ON j.genero.id = g.id WHERE g.nombre = :genero")
    Optional<List<JuegoEntity>> getAllByNombreGenero(@Param("genero") String genero);

}
