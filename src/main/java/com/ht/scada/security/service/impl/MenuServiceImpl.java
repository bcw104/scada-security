package com.ht.scada.security.service.impl;

import com.ht.scada.security.dao.MenuItemDao;
import com.ht.scada.security.dao.MenuTypeDao;
import com.ht.scada.security.entity.MenuItem;
import com.ht.scada.security.entity.MenuType;
import com.ht.scada.security.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Inject
	private MenuItemDao menuItemDao;
        @Inject
	private MenuTypeDao menuTypeDao;
        @Override
	public List<MenuType> getAllMenuTypes() {
		return menuTypeDao.findAll();
	}
        @Override
        public List<MenuItem> getAllMenuItem(){
            return menuItemDao.findAll();
        }
       
}
