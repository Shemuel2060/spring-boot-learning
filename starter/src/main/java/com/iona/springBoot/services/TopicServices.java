package com.iona.springBoot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iona.springBoot.models.entities.Topic;

@Service // label this a business service
/* Spring initialises this once as a singleton making it available wherever it is needed.*/
public class TopicServices {
	
	// a list of topics - can be got from the DB
	
	/*Arrays.asList() returns an immutable List<Object>, so we cannot add to it or delete
	 * from it. To be able to do this, we instead use a mutable ArrayList */
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			
			new Topic(1L,"Spring Core","An introduction to the core features of spring"),
			new Topic(2L,"Spring MVC","Using spring to create web apps"),
			new Topic(3L,"Spring Boot","Bootstrap your spring applications")

			
			));

	
	public List<Topic> getAllTopics(){
		return topics; // LIST OF TOPICS SHOULD BE GOT FROM THE db
	}
	
	public Topic getTopic(Long id) {
		/* This is one of the ways, but other ways exist.
		 * The idea here is using the Streams API, filter it based on a 
		 * predicate and find and get the first matching item.
		 * */
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void deleteTopic(Long id) {
		/* the list's removeIf() takes a predicate, which, if true, 
		 * removes the element from the list
		 * 
		 * */
		topics.removeIf(t -> t.getId().equals(id));
		
	}

	public void updateTopic(Long id, Topic updatedTopic) {
		// can use the Stream API or a for loop
		for(int i = 0; i<topics.size(); i++) {
			// check each topics id, if matches entered one
			if(topics.get(i).getId().equals(id)){
				// replace this topic with the updated topic
				topics.set(i, updatedTopic);
				return;
			}
		}
		
	}
}
