package tup.bibliotecasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tup.bibliotecasteam.dtos.UsuarioBibliotecaDto;
import tup.bibliotecasteam.dtos.UsuariosHorasTotalesDto;
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

    //6. "Listar usuarios por mayor cantidad de horas registradas en juegos"
    @Query("SELECT new tup.bibliotecasteam.dtos.UsuariosHorasTotalesDto(u.id, u.nombre, u.pais, u.nivel, SUM(b.horas)) " +
            "FROM UsuarioEntity u " +
            "LEFT JOIN BibliotecaEntity b ON b.usuario.id = u.id " +
            "GROUP BY u.id, u.nombre, u.pais, u.nivel " +
            "ORDER BY SUM(b.horas) DESC, u.nivel DESC, u.nombre ASC, u.pais ASC")
    List<UsuariosHorasTotalesDto> findUsuariosXHorasTotales();

    //7. "Listar usuarios que hayan jugado comprado <NOMBRE DEL JUEGO>"
    @Query("SELECT u FROM UsuarioEntity u " +
            "LEFT JOIN BibliotecaEntity b ON b.usuario.id = u.id " +
            "JOIN JuegoEntity j ON b.juego.id = j.id " +
            "WHERE j.nombre = :juego " +
            "ORDER BY u.nivel DESC, u.nombre ASC, u.pais ASC")
    Optional<List<UsuarioEntity>> findUsuariosPorJuego(@Param("juego") String juego);
}
