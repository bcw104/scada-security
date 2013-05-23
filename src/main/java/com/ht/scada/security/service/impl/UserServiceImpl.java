package com.ht.scada.security.service.impl;

import com.ht.scada.security.ShiroDbRealm.ShiroUser;
import com.ht.scada.security.dao.UserDao;
import com.ht.scada.security.dao.UserExtInfoDao;
import com.ht.scada.security.dao.UserRoleDao;
import com.ht.scada.security.entity.User;
import com.ht.scada.security.entity.UserExtInfo;
import com.ht.scada.security.entity.UserRole;
import com.ht.scada.security.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDao userDao;
	
	@Inject
	private UserRoleDao userRoleDao;

	@Inject
	private UserExtInfoDao userExtInfoDao;

	@Override
	public User getCurrentUser() {
		//final Integer currentUserId = (Integer) SecurityUtils.getSubject().getPrincipal();
		final ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		
        if( shiroUser != null ) {
            return getUserByUsername(shiroUser.userame);
        } else {
            return null;
        }
	}

	@Override
	public void createUser(String username, String password) {
		User user = new User();
        user.setUsername(username);
        user.setPassword( new Sha256Hash(password).toHex() );
        userDao.save(user);
	}
	
	@Override
	public void addNewUser(User newUser) {
		userDao.save(newUser);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUser(int userId) {
		return userDao.findOne(userId);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void deleteUser(int userId) {
		userDao.delete(userId);
	}
        @Override
        public void deleteUserRole(int id){
            userRoleDao.delete(id);
        }
	@Override
	public void updateUser(User user) {
		userDao.save(user);
	}

	@Override
	public void createUserRole(String name, String description) {
		UserRole role = new UserRole();
		role.setName(name);
		role.setDescription(description);
		userRoleDao.save(role);
	}
	
	@Override
	public void saveUserRole(UserRole userRole) {
		userRoleDao.save(userRole);
	}
	
	@Override
	public UserRole getUserRoleByName(String name) {
		return userRoleDao.findByName(name);
	}
	@Override
	public void updateUserPassword(String password, int id){
		userDao.updateUserPassword(password, id);
	}
	@Override
	public List<UserExtInfo> getAllUserExtInfo() {
		
		return userExtInfoDao.findAll();
	}
        @Override
        public List<UserRole> getAllUserRole(){
            return userRoleDao.findAll();
        }
        @Override
        public void  saveUserExtInfo(UserExtInfo newUser) {
		userExtInfoDao.save(newUser);
	}
        @Override
        public UserRole getUserRoleById(int id){
            return userRoleDao.findOne(id);
        }
        @Override
        public UserExtInfo findUserExtInfoByUserID(int id){
            return userExtInfoDao.findByUserID(id);
        }
        
    /**
    * 保存用户信息
    * @param newUser 
    * 2013-05-20 zhaowei Add
    */
    @Override
    public void  saveUser(User newUser) {
        userDao.save(newUser);
	}
    
    /**
     * 获得用户信息（根据用户ID）
     * @param id
     * @return 
     * 2013-05-21 zhaowei Add
     */
    @Override
    public User findUserByUserID(int id){
        return userDao.findByUserID(id);
    }
}
