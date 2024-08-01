package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tup.bibliotecasteam.entities.GeneroEntity;

import java.util.Optional;

@Repository
public interface GeneroJpaRepository extends JpaRepository<GeneroEntity, Long> {
    Optional<GeneroEntity> findByNombre(String nombre);
}
