package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tup.bibliotecasteam.entities.PerfilEntity;

@Repository
public interface PerfilJpaRepository extends JpaRepository<PerfilEntity, Long> {

}
