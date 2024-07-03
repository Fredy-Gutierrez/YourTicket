package com.yourticket.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class SellerReqDTO {
    private int sellerID;
    
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 2, max = 100, message = "El nombre debe contener al menos {min} letras y menos de {max}")
    private String name;
    
    @NotBlank(message = "La informacion es requerida")
    @Size(min = 2, message = "La informacion debe contener al menos {min} letras")
    private String information;
    
    @NotBlank(message = "El RFC es requerida")
    @Size(min = 2, max = 20, message = "El RFC debe contener al menos {min} letras y menos de {max}")
    private String rfc;
    
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
