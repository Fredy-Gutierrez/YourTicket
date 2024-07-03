package com.yourticket.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fredd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerReqDTO {
    private int customerID;
    
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 2, max = 30, message = "El nombre debe contener al menos {min} letras y menos de {max}")
    private String name;
    
    @NotBlank(message = "El apellido es requerido")
    @Size(min = 2, max = 50, message = "El apellido debe contener al menos {min} letras y menos de {max}")
    private String lastName;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha de nacimiento es requerida")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    private LocalDate birthDay;
    
    @NotBlank(message = "El pais es requerido")
    @Size(min = 2, max = 30, message = "El pais debe contener al menos {min} letras y menos de {max}")
    private String country;
    
    @NotBlank(message = "La direccion es requerida")
    @Size(min = 2, max = 100, message = "La direccion debe contener al menos {min} letras y menos de {max}")
    private String address;
    
    @NotBlank(message = "El email es requerido")
    @Size(min = 2, max = 50, message = "El email debe contener al menos {min} letras y menos de {max}")
    @Email(message = "El email es invalido", flags = { Pattern.Flag.CASE_INSENSITIVE } )
    private String email;
    
    @NotBlank(message = "El telefono es requerido")
    @Size(min = 2, max = 15, message = "El telefono debe contener al menos {min} letras y menos de {max}")
    private String phone;
    
    
    private int userID;
}
