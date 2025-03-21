package io.iona.joblink.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.iona.joblink.models.entities.Client;
import io.iona.joblink.models.services.ClientServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Clients", description="Operations related to clients") /* Using a swagger
annotation to label this as a section in the documentation*/
@RestController
public class UserController {

	@Autowired // to inject this dependency here
	private ClientServices clientServices;
	
	@GetMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
	
	/* 
	 * 
	 * The controller handler needs to return a type of what is expected from it, 
	 * e.g. String, List<Object, etc. The return in @RestController is automatically
	 * converted to JSON format and displayed on the web page.
	 * 
	 * 
	 * Routing to this endpoint displays json data on the webpage with
	 * the model's field names as ids, and these as values. This is helpful in
	 * creating RestFul APIs with endpoints.
	 * */
	@Operation(
			summary="Get all clients",
			description="Returns a list of clients using a service call")
	@GetMapping("/clients")
	public List<Client> getAllClients(){
		
		return clientServices.getAllClients();
		
	}
	
	/* To inform spring for a dynamic id of a User, we use the path variable using
	 * the @PathVariable to indicate that the specified path variable should be 
	 * passed to the handler method as an argument
	 * 
	 * The approach used below is recommended, but it is also possible to have
	 * "/Users/{foo}" and define the @PathVariable("foo") Long id in the method
	 * 
	 * */
	@Operation(
			summary="Get a given clients",
			description="Returns a single client by their id extracted from the request url")
	@GetMapping("/clients/{id}") // {id} a path variable
	public Client getClient(@PathVariable Long id) {
		
		
		// TODO throw and handle java.util.NoSuchElementException: No value present
		return clientServices.getClient(id);
	}
	
	
	// POST 
	@Operation(
			summary="Add a new client",
			description="Uses a request body for a new client"
			)
	
	@PostMapping("/clients")
	public void addClient(@RequestBody Client client) {
		/* To have the User object directly returned as json, i define it
		 * with @RequestBody
		 * 
		 *  If it was not to be as a json format, such as form data, spring would
		 *  try binding it...??
		 *  
		 *  In such cases, it does new entries.
		 *  
		 *  - */
		clientServices.addClient(client);
	}
	
	@PutMapping("/clients/{id}")
	public void updateClient(@RequestBody Client updatedClient, @PathVariable Long id) {
		
	
		clientServices.updateClient(id, updatedClient);
	}
	
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientServices.deleteClient(id);
	}
	
	
	
	
	
	
	
	
}
