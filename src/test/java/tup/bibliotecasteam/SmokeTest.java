package tup.bibliotecasteam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tup.bibliotecasteam.controllers.*;
import tup.bibliotecasteam.services.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private PingController pingController;
    @Autowired
    private UsuarioController usuarioController;
    @Autowired
    private BibliotecaController bibliotecaController;
    @Autowired
    private JuegoController juegoController;
    @Autowired
    private PerfilController perfilController;
    @Autowired
    private ControllerExceptionHandler exceptionHandler;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private GeneroService generoService;
    @Autowired
    private JuegoService juegoService;
    @Autowired
    private PerfilService perfilService;
    @Autowired
    private BibliotecaService bibliotecaService;


    @Test
    public void contextLoads() throws Exception {
        assertThat(pingController).isNotNull();
        assertThat(usuarioController).isNotNull();
        assertThat(bibliotecaController).isNotNull();
        assertThat(juegoController).isNotNull();
        assertThat(perfilController).isNotNull();
        assertThat(exceptionHandler).isNotNull();
        assertThat(usuarioService).isNotNull();
        assertThat(generoService).isNotNull();
        assertThat(juegoService).isNotNull();
        assertThat(perfilService).isNotNull();
        assertThat(bibliotecaService).isNotNull();
    }
}
