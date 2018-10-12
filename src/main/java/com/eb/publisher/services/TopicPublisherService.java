package com.eb.publisher.services;

import java.util.List;

import com.eb.publisher.exception.EBPublisherAPIException;
import com.eb.publisher.model.PublishList;
import com.eb.publisher.model.UrlPublish;

public interface TopicPublisherService {
	
	/**
	 * This method fetch all the published topics and filter out the topic based
	 * on provided topicId.
	 * 
	 * @param topicId
	 * @return topic {@link UrlPublish}
	 * @throws EBPublisherAPIException 
	 */
	public UrlPublish fetchTopicById(String topicId) throws EBPublisherAPIException;

	/**
	 * This method fetch all the published topics and filter out the topic based
	 * on provided class name.
	 * 
	 * @param className
	 * @return
	 * @throws EBPublisherAPIException 
	 */
	public List<UrlPublish> fetchTopicsByClass(String className) throws EBPublisherAPIException;


	/**
	 * This method fetch all the published topics
	 * 
	 * @return
	 * @throws EBPublisherAPIException 
	 */
	public PublishList fetchAllTopics() throws EBPublisherAPIException;

}
