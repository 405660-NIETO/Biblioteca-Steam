package tup.bibliotecasteam.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
    @Schema(title = "User's email",
            description = "Your account email",
            example = "example@mail.com",
            nullable = false)
    private String email;
    @NotNull(message = "Identity can't be null")
    private String password;
}
