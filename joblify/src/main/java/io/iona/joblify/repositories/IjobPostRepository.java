package io.iona.joblify.repositories;

import org.springframework.data.repository.CrudRepository;

import io.iona.joblify.models.entities.JobPost;

public interface IjobPostRepository extends CrudRepository<JobPost, Long>{
	// provides the basic CRUD methods out-of-the box
	
	
}
