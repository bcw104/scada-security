/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.security.service;

import com.ht.scada.security.entity.MenuItem;
import com.ht.scada.security.entity.MenuType;

import java.util.List;

public interface MenuService {
     List<MenuItem> getAllMenuItem();

    List<MenuType> getAllMenuTypes();
}
