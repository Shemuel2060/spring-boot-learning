package io.iona.joblify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.iona.joblify.models.entities.JobPost;
import io.iona.joblify.models.services.JobPostServices;

@RestController
public class JobPostController {

	@Autowired // to inject this dependency here
	private JobPostServices jobPostServices;
	
	
	@GetMapping("/jobPosts")
	public List<JobPost> getAllJobs(){
		
		return jobPostServices.getAllJobPosts();
		
	}
	
	/* 
	 * use this @GetMapping("/jobPosts/{id}") if job posts ids are globally
	 * unique
	 * */
	@GetMapping("/clients/{companyId}/jobPosts/{id}") // {id} a path variable
	public JobPost getJobPost(@PathVariable Long id) {
		
		
		return jobPostServices.getJobPost(id);
	}
	
	
	// POST 
	@PostMapping("/clients/{companyId}/jobPosts")
	public void addJobPost(@PathVariable Long companyId, @RequestBody JobPost jobPost) {
		/* To have the User object directly returned as json, i define it
		 * with @RequestBody
		 * 
		 *  If it was not to be as a json format, such as form data, spring would
		 *  try binding it...??
		 *  
		 *  In such cases, it does new entries.
		 *  
		 *  - */
		jobPostServices.addJobPost(companyId, jobPost);
	}
	
	@PutMapping("/clients/{companyId}/jobPosts/{id}")
	public void updateJobPost(@PathVariable Long companyId, @RequestBody JobPost updatedJobPost, 
			@PathVariable Long id) {
		
	
		jobPostServices.updateJobPost(companyId, updatedJobPost);
	}
	
	@DeleteMapping("/jobPosts/{id}")
	public void deleteJobPost(@PathVariable Long id) {
		jobPostServices.deleteJobPost(id);
	}
	
	
	
	
	
	
	
	
}
