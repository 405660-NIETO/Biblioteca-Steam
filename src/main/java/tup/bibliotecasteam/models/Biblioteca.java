package tup.bibliotecasteam.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Biblioteca {
    private Long id;
    private Juego juego;
    private Usuario usuario;
    private Integer horas;
    private Integer logros;
    private String review;
}
