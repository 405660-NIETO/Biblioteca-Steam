package tup.bibliotecasteam.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import tup.bibliotecasteam.dtos.UsuarioBibliotecaDto;
import tup.bibliotecasteam.entities.BibliotecaEntity;
import tup.bibliotecasteam.entities.JuegoEntity;
import tup.bibliotecasteam.entities.UsuarioEntity;
import tup.bibliotecasteam.models.Biblioteca;
import tup.bibliotecasteam.models.Usuario;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioJpaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @Test
    public void findByEmailAndPasswordTest() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail("agus@mail.com");
        usuario.setPassword("123456789");
        usuario.setNombre("Agus");

        entityManager.persist(usuario);
        entityManager.flush();

        Optional<UsuarioEntity> resultado = usuarioJpaRepository.findByEmailAndPassword("agus@mail.com","123456789");
        assertEquals("Agus", resultado.get().getNombre());
    }

    @Test
    public void findUsuariosXCantidadJuegosTest() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombre("Agus");
        usuario.setPais("Argentina");
        usuario.setNivel(7);

        JuegoEntity juego = new JuegoEntity();
        juego.setNombre("Test");

        BibliotecaEntity biblioteca = new BibliotecaEntity();
        biblioteca.setJuego(juego);
        biblioteca.setUsuario(usuario);
        biblioteca.setHoras(7);
        biblioteca.setReview("0");
        biblioteca.setLogros(7);

        entityManager.persist(usuario);
        entityManager.persist(juego);
        entityManager.persist(biblioteca);
        entityManager.flush();

        List<UsuarioBibliotecaDto> resultado = usuarioJpaRepository.findUsuariosXCantidadJuegos();
        assertFalse(resultado.isEmpty());
    }
}