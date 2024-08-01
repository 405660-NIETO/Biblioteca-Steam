package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tup.bibliotecasteam.entities.UsuarioEntity;

import java.util.Optional;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmailAndPassword(String email, String password);

//    @Query("UPDATE UsuarioEntity u SET u.lastLogin = GETDATE() WHERE u.email = :email")
//    void updateLastLogin(@Param("email") String email);
}
