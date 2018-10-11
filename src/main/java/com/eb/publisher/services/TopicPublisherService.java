package com.eb.publisher.services;

import java.util.List;

import com.eb.publisher.model.Topic;

public interface TopicPublisherService {
	public Topic fetchTopicById(String topicId);
	public List<Topic> fetchTopicsByClass(String className);
	public List<Topic> fetchAllTopics();

}
