package com.yourticket.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
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
public class EventReqDTO {
    private int eventID;
    
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 2, max = 100, message = "El nombre debe contener al menos {min} letras y menos de {max}")
    private String eventName;
    
    @NotBlank(message = "La informacion es requerida")
    @Size(min = 2, message = "La informacion debe contener al menos {min} letras")
    private String information;
    
    @NotBlank(message = "La localizacion es requerida")
    @Size(min = 2, max = 250,message = "La localizacion debe contener al menos {min} letras y menos de {max}")
    private String localization;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @NotNull(message = "La fecha de nacimiento es requerida")
    @Future(message = "La fecha del evento debe ser superior a la fecha actual")
    private LocalDateTime eventDay;
    
    private String status;
    
    private int userID;
}
