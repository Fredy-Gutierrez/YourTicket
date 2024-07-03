package com.yourticket.dtos.request;

import jakarta.validation.constraints.NotBlank;
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
public class UserReqDTO {
    private int userID;
    
    @NotBlank(message = "El nombre de usuario es requerido")
    @Size(min = 2, max = 50, message = "El nombre de usuario debe contener al menos {min} letras y menos de {max}")
    private String userName;
    
    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 2, message = "La contraseña debe contener al menos {min} letras/digitos")
    private String userPassword;
    
    private boolean available;
    
    private String userRole;
    
    private int roleID;
}
