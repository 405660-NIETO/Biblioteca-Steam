package tup.bibliotecasteam.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tup.bibliotecasteam.dtos.Credentials;
import tup.bibliotecasteam.models.Usuario;
import tup.bibliotecasteam.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(
            summary = "Logea un usuario a la plataforma",
            description = "Devuelve el usuario logeado si sus credenciales son correctas.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content =
            @Content(schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "404", description = "Email and Password are not in the database!", content =
            @Content(schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content =
            @Content(schema = @Schema(implementation = Usuario.class))),
    })
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody @Valid Credentials credentials){
        Usuario usuario = usuarioService.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword());

        return ResponseEntity.ok(usuario);
    }
}
