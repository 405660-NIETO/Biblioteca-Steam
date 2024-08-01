package tup.bibliotecasteam.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Schema(title = "Usuario ID",  description = "El identificador del Usuario", example = "7")
    private Long id;
    private String email;
    private String password;
    @Schema(title = "Nombre del Usuario",  description = "El nombre del usuario", example = "MiNombre")
    @NotNull(message = "El nombre no puede ser null!")
    private String nombre;
    private String pais;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime lastLogin;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime createdAt;
    private Integer nivel;
}
