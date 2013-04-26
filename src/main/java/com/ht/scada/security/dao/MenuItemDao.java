/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.security.dao;


import com.ht.scada.security.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrator
 */
public interface MenuItemDao extends JpaRepository<MenuItem, Integer>{
    
}
