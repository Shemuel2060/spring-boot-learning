package io.iona.joblink.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.iona.joblink.models.entities.Client;
import io.iona.joblink.repositories.IclientRepository;

@Service // label this a business service
/* Spring initialises this once as a singleton making it available wherever it is needed.*/
public class ClientServices {
	
	@Autowired // inject repository in the service
	IclientRepository clientRepository; 
	

	public List<Client> getAllClients(){
		
		List<Client> clients = new ArrayList<>();
		clientRepository.findAll() // since an iterable
					  .forEach(clients::add); // method references
		
		return clients;
	}
	
	public Client getClient(Long id) {
		
		return clientRepository.findById(id).get();
		
		
	}

	public void addClient(Client client) {
		
		clientRepository.save(client);
		
		
	}

	public void deleteClient(Long id) {
		
		clientRepository.deleteById(id);
		
	}

	public void updateClient(Long id, Client updatedClient) {
		
		clientRepository.save(updatedClient);
		/* This method does both saving and updating. If it detects that
		 * the updated user's id already exists, then it does an update,
		 * otherwise, it does a new save.
		 * 
		 * However, what happens if an update changes all values in the
		 * row including the id???
		 * */
		
	}
}
