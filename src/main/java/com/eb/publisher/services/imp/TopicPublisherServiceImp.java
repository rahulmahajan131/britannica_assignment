package com.eb.publisher.services.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eb.publisher.model.Topic;
import com.eb.publisher.services.TopicPublisherService;
import com.eb.publisher.util.XmlParserUtility;

@Service
public class TopicPublisherServiceImp implements TopicPublisherService {

	@Override
	public Topic fetchTopicById(String topicId) {
		List<Topic> topics=XmlParserUtility.parseXML(getClass().getClassLoader().getResource("britannica_topics.xml").getPath());
		Optional<Topic> opTopic = topics.stream().filter(t -> t.getTopicId().equals(topicId)).findFirst();
		return opTopic.isPresent() ? opTopic.get() : null;
	}

	@Override
	public List<Topic> fetchTopicsByClass(String className) {
		List<Topic> topics=XmlParserUtility.parseXML(getClass().getClassLoader().getResource("britannica_topics.xml").getPath());
		List<Topic> topicsByClass = topics.stream().filter(t -> t.getUrlClass().equals(className)).collect(Collectors.toList());
		return topicsByClass;
	}

	@Override
	public List<Topic> fetchAllTopics() {
		List<Topic> topics= XmlParserUtility.parseXML(getClass().getClassLoader().getResource("britannica_topics.xml").getPath());
		System.out.println(topics);
		return topics;
	}

}
