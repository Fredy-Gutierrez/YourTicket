package com.yourticket.repositories;

import com.yourticket.entities.RoleEntity;

/**
 *
 * @author fredd
 */
public interface IRoleRepository {
    public RoleEntity getRole(int roleId);
}
