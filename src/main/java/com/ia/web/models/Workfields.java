package com.ia.web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "workfields")
public class Workfields {
	
	@Id
	@Column(name = "image")
	@Expose
	private Long image;
	
	@Column(name = "area")
	@Expose
	private String area;
	
}
