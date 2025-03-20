package io.iona.joblify.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class JobPost {
	
	@Id
	private Long jobPostId;
	private String name;
	private String description;
	
	@ManyToOne // one company can have many job posts
	private Client company; // company that made the job post
	
	public JobPost() {}
	
	
	public JobPost(Long jobPostId, String name, String description) {
		this.jobPostId = jobPostId;
		this.name = name;
		this.description = description;
	}



	public Long getJobPostId() {
		return jobPostId;
	}


	public void setJobPostId(Long jobPostId) {
		this.jobPostId = jobPostId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


	public Client getCompany() {
		return company;
	}


	public void setCompany(Client company) {
		this.company = company;
	}


	
	

}
