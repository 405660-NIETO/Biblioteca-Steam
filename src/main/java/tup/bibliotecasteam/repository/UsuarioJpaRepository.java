package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tup.bibliotecasteam.dtos.UsuarioBibliotecaDto;
import tup.bibliotecasteam.entities.UsuarioEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmailAndPassword(String email, String password);

    //5. "Listar usuarios con la mayor cantidad de juegos comprados"
    @Query("SELECT new tup.bibliotecasteam.dtos.UsuarioBibliotecaDto(u.id, u.nombre, u.pais, u.nivel, COUNT(b.juego.id)) " +
            "FROM UsuarioEntity u " +
            "LEFT JOIN BibliotecaEntity b ON b.usuario.id = u.id " +
            "GROUP BY u.id, u.nombre, u.pais, u.nivel " +
            "ORDER BY COUNT(b.juego.id) DESC, u.nivel DESC, u.nombre ASC, u.pais ASC")
    List<UsuarioBibliotecaDto> findUsuariosXCantidadJuegos();
}
