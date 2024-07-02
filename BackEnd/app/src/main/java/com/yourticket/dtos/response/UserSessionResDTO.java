package com.yourticket.dtos.response;

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
public class UserSessionResDTO {
    private int userID;
    private String userName;
    private String userRole;
    private String token;
}
