package com.ht.scada.security.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
	private String gender;
	private String department;
	private String email;
	private String address;
	private String realName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id")
	private UserRole userRole;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name = "T_User_MajorTag")
	@Column(name = "major_tag_id")
	private Set<Integer> majorTagID;// user:edit,user:add
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name = "T_User_endTag")
	@Column(name = "end_tag_id")
	private Set<Integer> endTagID;// user:edit,user:add
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    public Set<Integer> getMajorTagID() {
        return majorTagID;
    }

    public void setMajorTagID(Set<Integer> majorTagID) {
        this.majorTagID = majorTagID;
    }

    public Set<Integer> getEndTagID() {
        return endTagID;
    }

    public void setEndTagID(Set<Integer> endTagID) {
        this.endTagID = endTagID;
    }
}
