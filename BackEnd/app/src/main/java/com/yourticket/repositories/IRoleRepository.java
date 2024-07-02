/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yourticket.repositories;

import com.yourticket.entities.RoleEntity;

/**
 *
 * @author fredd
 */
public interface IRoleRepository {
    public RoleEntity getRole(int roleId);
}
