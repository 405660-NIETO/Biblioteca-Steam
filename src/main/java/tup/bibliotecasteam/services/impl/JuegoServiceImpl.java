package tup.bibliotecasteam.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tup.bibliotecasteam.dtos.JuegoDTO;
import tup.bibliotecasteam.entities.BibliotecaEntity;
import tup.bibliotecasteam.entities.JuegoEntity;
import tup.bibliotecasteam.models.Biblioteca;
import tup.bibliotecasteam.models.Juego;
import tup.bibliotecasteam.repository.BibliotecaJpaRepository;
import tup.bibliotecasteam.repository.JuegoJpaRepository;
import tup.bibliotecasteam.services.JuegoService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class JuegoServiceImpl implements JuegoService {

    @Autowired
    private JuegoJpaRepository juegoJpaRepository;
    @Autowired
    private BibliotecaJpaRepository bibliotecaJpaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Juego findByNombre(String nombre) {
        Optional<JuegoEntity> juegoEntity = juegoJpaRepository.findByNombre(nombre);
        if (juegoEntity.isEmpty()){
            throw new EntityNotFoundException("Juego no encontrado!");
        }
        return modelMapper.map(juegoEntity, Juego.class);
    }

    @Override
    public List<Juego> getAllByNombreGenero(String genero) {
        List<Juego> listJuegos = new ArrayList<>();
        Optional<List<JuegoEntity>> juegoEntityList = juegoJpaRepository.getAllByNombreGenero(genero);
        juegoEntityList.ifPresent(list -> list.forEach(
                juegoEntity -> listJuegos.add(modelMapper.map(juegoEntity, Juego.class))
        ));
        /*
        for (JuegoEntity juegoEntity : juegoEntityList.get()) {
            listJuegos.add(modelMapper.map(juegoEntity, Juego.class));
        }
        */
        if (listJuegos.isEmpty()){
            throw new EntityNotFoundException("Ningun juego encontrado!");
        }
        return listJuegos;
    }

    // Punto 1
    @Override
    public List<Juego> juegosQueTengan(String palabra) {
        List<Juego> listaJuego = new ArrayList<>();
        Optional<List<JuegoEntity>> entityList = juegoJpaRepository.getAllJuegosLike(palabra);
        entityList.ifPresent(list -> list.forEach(
                entity -> listaJuego.add(modelMapper.map(entity, Juego.class))
        ));
        if (listaJuego.isEmpty()){
            throw new EntityNotFoundException("No se encontraron coincidencias!");
        }
        return listaJuego;
    }

    @Override
    public List<JuegoDTO> juegosPorReviewAscendente() {
        List<JuegoDTO> lstDTO = new ArrayList<>();
        Optional<List<BibliotecaEntity>> entityList =
                bibliotecaJpaRepository.getBibliotecasPerReview();

        if (entityList.isPresent())
        {
            List<BibliotecaEntity> bibliotecas = entityList.get();

            int contador = 0;
            boolean x = true;
            JuegoEntity juegoReservado = new JuegoEntity();
            for (BibliotecaEntity bibliot : bibliotecas)
            {
                if (x) //Primera
                {
                    juegoReservado = juegoJpaRepository.
                            getReferenceById(bibliot.getJuego().getId()); //Guardo el juego para la comparacion
                    contador++; //Lo cuento
                    x = false;
                }
                else //No es la primera
                {
                    if (bibliot.getJuego().getId().equals(juegoReservado.getId())) //Es el mismo juego?
                    {
                        contador++;
                    }
                    else // es otro
                    {
                        //JuegoDTO
                        JuegoDTO juegoDTO = modelMapper.map(juegoReservado, JuegoDTO.class);
                        juegoDTO.setCantReviews(contador); // -> Seteo la cantidad de reviews del juego
                        lstDTO.add(juegoDTO); // -> Añado a la lista retorno

                        //Reinicio contador y reemplazo por la nueva instancia juegoEntity
                        contador = 1;
                        juegoReservado = juegoJpaRepository.
                                getReferenceById(bibliot.getJuego().getId()); //Guardo el juego para la comparacion
                    }
                }
            }
            // Añadir el último juego procesado fuera del bucle
            JuegoDTO ultimoJuegoDTO = modelMapper.map(juegoReservado, JuegoDTO.class);
            ultimoJuegoDTO.setCantReviews(contador);
            lstDTO.add(ultimoJuegoDTO);

            //Mayor a menor
            lstDTO.sort(Comparator.comparingInt
                    (JuegoDTO::getCantReviews).reversed()); //Reversed (originalmente menor a mayor)
            return lstDTO;
        }
        else
        {
            throw new EntityNotFoundException("No hay juegos con reviews");
        }
    }
}
