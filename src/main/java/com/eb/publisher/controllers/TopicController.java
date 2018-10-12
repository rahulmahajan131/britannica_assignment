package com.eb.publisher.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eb.publisher.exception.EBPublisherAPIException;
import com.eb.publisher.model.PublishList;
import com.eb.publisher.model.UrlPublish;
import com.eb.publisher.response.ErrorTopicResponse;
import com.eb.publisher.services.TopicPublisherService;
/**
 * <h1>Topic Controller</h1> This controller manage all the services that fetch the topics based on different input.
 *  
 * @author Rahul Mahajan
 * @version 1.0
 * @since 10-12-2018
 *
 */
@RestController
@Validated
@RequestMapping("eb")
public class TopicController {

	private static final String VALID_CLASS_REGEXP = "animal|art|biography|event|place|plant|science|sports|technology|topic";

	@Autowired
	private TopicPublisherService topicPublisherService;

	
	/**
	 * This Api fetch the topic based on topicId, if you want retrieve topic with id 257 send a Get request as below
	 * "eb/topic/257"   
	 * @param topicId
	 * @return topic object {@link UrlPublish}
	 * @throws EBPublisherAPIException 
	 */
	@GetMapping(path = "/topic/{topicId}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> getTopicById(@PathVariable("topicId") String topicId) throws EBPublisherAPIException {
		UrlPublish urlPublish = topicPublisherService.fetchTopicById(topicId);
		if(urlPublish!=null){
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_XML).body(urlPublish);
		}else{
			ErrorTopicResponse errorTopicResponse = new ErrorTopicResponse();
			errorTopicResponse.setTopicid(topicId);
			errorTopicResponse.setError("URL Not Found");
			errorTopicResponse.setCause("Topic "+topicId+" not in database");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_XML).body(errorTopicResponse);
		}
	}


	/**
	 * This Api fetch the topics based on class name
	 * Valid class names [aminal,art,biography,event,plant,science,sport,technology,topic]
	 * for invalid input <b>ConstraintViolationException<b> exception is thrown and proper error message is sent as response to user.
	 * @param className
	 * @return topic list {@link PublishList}
	 * @throws EBPublisherAPIException 
	 */
	@GetMapping(path = "/class/{className}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> getTopicsByClassName(
			@Valid @Pattern(regexp = VALID_CLASS_REGEXP, flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid class name") @PathVariable("className") String className) throws EBPublisherAPIException {
		List<UrlPublish> topicsByClass = topicPublisherService.fetchTopicsByClass(className);
		PublishList publishList = new PublishList();
		publishList.getUrlPublish().addAll(topicsByClass);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_XML).body(publishList);
	}

	/**
	 * This Api fetch all the topics.
	 * 
	 * @return topics {@link PublishList}
	 * @throws EBPublisherAPIException 
	 */
	@GetMapping(path = "/all/topic", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> getAllTopics() throws EBPublisherAPIException {
		PublishList topics = topicPublisherService.fetchAllTopics();
		return ResponseEntity.status(HttpStatus.OK).body(topics);
	}

}
