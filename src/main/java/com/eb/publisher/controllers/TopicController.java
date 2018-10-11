package com.eb.publisher.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eb.publisher.model.Topic;
import com.eb.publisher.services.TopicPublisherService;

@RestController
@RequestMapping("eb")
public class TopicController {

	@Autowired
	private TopicPublisherService topicPublisherService;

	@GetMapping(path="/topic/{topicId}",produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> getTopicById(@PathVariable("topicId") String topicId) {
		Topic topic=topicPublisherService.fetchTopicById(topicId);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_XML).body(topic);
	}

	@GetMapping(path="/class/{className}",produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> getTopicsByClassName(@PathVariable("className") String className) {
		List<Topic> topicsByClass = topicPublisherService.fetchTopicsByClass(className);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_XML).body(topicsByClass);
	}
	
	@GetMapping(path="/all/topic",produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> getAllTopics() {
		List<Topic> topics= topicPublisherService.fetchAllTopics();
		return  ResponseEntity.status(HttpStatus.OK).body(topics);
	}


}
