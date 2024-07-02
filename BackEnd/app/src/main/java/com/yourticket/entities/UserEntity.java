package com.yourticket.entities;

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
public class UserEntity {
    private int userID;
    private String userName;
    private String userPassword;
    private boolean available;
    private int roleID;
}
