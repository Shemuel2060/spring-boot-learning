package io.iona.joblink.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.iona.joblink.models.entities.Client;
import io.iona.joblink.models.entities.JobPost;
import io.iona.joblink.repositories.IjobPostRepository;

@Service // label this a business service
/* Spring initialises this once as a singleton making it available wherever it is needed.*/
public class JobPostServices {
	
	@Autowired // inject repository in the service
	private IjobPostRepository jobPostRepository; 
	

	public List<JobPost> getAllJobPosts(){
		
		List<JobPost> jobPosts = new ArrayList<>();
		jobPostRepository.findAll() // since an iterable
					  .forEach(jobPosts::add); // method references
		
		return jobPosts;
	}
	
	public JobPost getJobPost(Long id) {
		
		return jobPostRepository.findById(id).get();
		
		
	}

	public void addJobPost(Long companyId, JobPost jobPost) {
		// construct company
		/*This prevents the user's explicit defining of which 
		 * company this job post belongs to. 
		 * 
		 * */
		Client company = new Client(companyId, "");
		jobPost.setCompany(company);
		
		jobPostRepository.save(jobPost);
		
		
	}

	public void deleteJobPost(Long id) {
		
		jobPostRepository.deleteById(id);
		
	}

	public void updateJobPost(Long companyId, JobPost updatedJobPost) {
		
		Client company = new Client(companyId, "");
		updatedJobPost.setCompany(company);
		/* The updated job post should only */
		
		jobPostRepository.save(updatedJobPost);
		
		
	}
}
