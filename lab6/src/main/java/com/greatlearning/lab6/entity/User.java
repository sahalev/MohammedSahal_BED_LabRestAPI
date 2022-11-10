package com.greatlearning.lab6.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode(of="userId")
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;
	
	private String userName;
	
	private String password;
	
	private String emailAddress;
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Role> roles;
	
	//scaffolding code
	public void addRole(Role role)
	{
		if(this.roles==null)
		{
			this.roles = new HashSet<>();
		}
		this.roles.add(role);
		role.setUser(this);
	}

}
