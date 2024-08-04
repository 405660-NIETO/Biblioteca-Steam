package tup.bibliotecasteam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tup.bibliotecasteam.models.Genero;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewJuegoDto {
    private Long id;
    private String nombre;
    private Long reviews;
}
