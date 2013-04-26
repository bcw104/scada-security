/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.security.dao;

import com.ht.scada.security.entity.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrator
 */
public interface MenuTypeDao extends JpaRepository<MenuType, Integer>{
}
