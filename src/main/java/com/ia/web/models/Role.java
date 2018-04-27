package com.ia.web.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Expose
	private String name;

	@Override
	public String getAuthority() {
		return this.name;
	}
	
	
}
