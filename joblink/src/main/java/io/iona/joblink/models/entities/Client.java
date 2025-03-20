package io.iona.joblink.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {
	
	@Id
	private Long id;
	private String name;
	
	public Client() {}
	
	public Client(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
