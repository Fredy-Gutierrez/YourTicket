package com.yourticket.dtos.request;

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
    private String userName;
    private String userPassword;
    private boolean available;
    private String userRole;
    private int roleID;
}
