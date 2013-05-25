package com.ht.scada.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.hibernate.annotations.Index;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="T_Users")
public class User extends AbstractPersistable<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1847175199422349100L;
	
	@Column(nullable=false, unique=true)
	@Index(name="idx_users_username")
	private String username;
	@Column(nullable=false)
	private String password;
	
    private String name;
    
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id")
	private UserRole userRole;
	
	public User() {
	}
	
	public User(Integer id) {
		this.setId(id);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    public void setShaPassword(String password){
        this.password=new Sha256Hash(password).toHex();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
}
