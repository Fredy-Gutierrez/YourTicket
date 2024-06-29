package com.yourticket.dtos.response;

import com.yourticket.dtos.request.*;
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
public class UserResDTO {
    private int userID;
    private String userName;
    private boolean available;
    private int roleID;
}
