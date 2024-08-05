package tup.bibliotecasteam.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perfil {
    private Long id;
    private Usuario usuario;
    private String descripcion;
    private String avatar;
    private String fondo;
}
