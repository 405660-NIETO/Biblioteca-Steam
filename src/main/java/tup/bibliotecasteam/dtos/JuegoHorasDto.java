package tup.bibliotecasteam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoHorasDto {
    private String nombre;
    private Long horasTotales;
}
