package com.iona.springBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iona.springBoot.models.entities.Topic;
import com.iona.springBoot.services.TopicServices;

@RestController
public class TopicsController {
	
	@Autowired // to inject this dependency here
	private TopicServices topicServices;
	
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
	@GetMapping("/topics")
	public List<Topic> getAllTopics(){
		
		return topicServices.getAllTopics();
		
	}
	
	/* To inform spring for a dynamic id of a topic, we use the path variable using
	 * the @PathVariable to indicate that the specified path variable should be 
	 * passed to the handler method as an argument
	 * 
	 * The approach used below is recommended, but it is also possible to have
	 * "/topics/{foo}" and define the @PathVariable("foo") Long id in the method
	 * 
	 * */
	@GetMapping("/topics/{id}") // {id} a path variable
	public Topic getTopic(@PathVariable Long id) {
		
		
		// TODO throw and handle java.util.NoSuchElementException: No value present
		return topicServices.getTopic(id);
	}
	
	
	// POST 
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		/* To have the topic object directly returned as json, i define it
		 * with @RequestBody
		 * 
		 *  If it was not to be as a json format, such as form data, spring would
		 *  try binding it...??
		 *  - */
		topicServices.addTopic(topic);
	}
	
	@PutMapping("/topics/update/{id}")
	public void updateTopic(@RequestBody Topic updatedTopic, @PathVariable Long id) {
		/* Here, you need to pass the updated topic as a RequestBody, like
		 * in post mapping, and the id of the topic to update in the request
		 * path as a path variable */
		
		topicServices.updateTopic(id, updatedTopic);
	}
	
	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable Long id) {
		topicServices.deleteTopic(id);
	}
	
	
	
	
	
	
	
	
	

}
