package tup.bibliotecasteam.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Bibliotecas")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id_juego")
    @ManyToOne
    private JuegoEntity juego;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private UsuarioEntity usuario;

    @Column(name = "horas")
    private Integer horas;

    @Column(name = "logros")
    private Integer logros;

    @Lob
    @Column(name = "review")
    private String review;
}
