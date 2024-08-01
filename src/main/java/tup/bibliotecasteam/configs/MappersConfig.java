package tup.bibliotecasteam.configs;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {
    /*
    @Bean
    public ModelMapper modelMapper() { return new ModelMapper(); }

     */

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean("mergerMapper")
    /*
    Esta anotacion se utiliza para indicar inequivocamente cual es el nombre que
    tendra un Bean. De esta manera podemos tener mas de Bean del mismo tipo en ApplicationContext.
     */
    //@Qualifier("mergerMapper")
    public ModelMapper mergerMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        return mapper;
    }
    @Bean
    public ObjectMapper objectMapper() {
        //agregar el manejo de fechas a Jenkins
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper;
    }
}