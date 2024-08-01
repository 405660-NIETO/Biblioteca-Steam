package tup.bibliotecasteam.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Juego {
    private Long id;
    private String nombre;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime releaseDate;
    private Integer precio;
    private Genero genero;
    private Integer logros;
    private String developer;
    private String publisher;
    private String rating;
}
