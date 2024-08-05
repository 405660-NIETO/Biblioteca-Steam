package tup.bibliotecasteam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioXLogros {
    private Long id;
    private String nombre;
    private String pais;
    private Integer nivel;
    private Long logrosTotales;
}
