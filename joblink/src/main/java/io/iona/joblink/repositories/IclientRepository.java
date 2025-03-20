package io.iona.joblink.repositories;

import org.springframework.data.repository.CrudRepository;

import io.iona.joblink.models.entities.Client;

/*
 * This interface needs to extend CrudRepository which includes
 * most of the common CRUD methods. The class that implements this
 * will automatically have them.It also an implementation for those
 * methods
 *  
 *  This CrudRepository<User, Long> is parameterized to indicate
 *  the entity to be applied to and the type of the primary key field
 *  
 *  This interface should only include unique business methods that are 
 *  not commonly CRUD methods.
 *  
 *  */
public interface IclientRepository extends CrudRepository<Client, Long>{
	// provides the basic CRUD methods out-of-the box
	
//	findByName(String name);
}
