package com.ia.web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "evaluations")
public class Evaluations {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		@Expose
		private Long id;
		
		@Column(name = "value")
		@Expose
		private String value;
		
		@Column(name = "user")
		@Expose
		private UserDetails user;
		
}
