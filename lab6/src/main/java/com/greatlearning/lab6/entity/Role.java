package com.greatlearning.lab6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString(exclude="user")
@EqualsAndHashCode(of="roleid")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleid;
	
	@Column(name="role_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="user_id_fk",nullable=false)
	private User user;
}
