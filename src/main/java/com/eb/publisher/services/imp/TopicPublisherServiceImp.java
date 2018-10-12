package com.eb.publisher.services.imp;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eb.publisher.exception.EBPublisherAPIException;
import com.eb.publisher.model.PublishList;
import com.eb.publisher.model.UrlPublish;
import com.eb.publisher.services.TopicPublisherService;
import com.eb.publisher.util.XmlParserUtility;

@Service
public class TopicPublisherServiceImp implements TopicPublisherService {
	
	@Override
	public UrlPublish fetchTopicById(String topicId) throws EBPublisherAPIException {
		File file = XmlParserUtility.getFile();
		PublishList publishList= XmlParserUtility.parseXML(file);
		Optional<UrlPublish> opTopic = publishList.getUrlPublish().stream().filter(t -> t.getTopicid()==Integer.parseInt(topicId)).findFirst();
		return opTopic.isPresent() ? opTopic.get() : null;
	}


	@Override
	public List<UrlPublish> fetchTopicsByClass(String className) throws EBPublisherAPIException {
		File file = XmlParserUtility.getFile();
		PublishList publishList=XmlParserUtility.parseXML(file);
		List<UrlPublish> urlPublishs =  publishList.getUrlPublish().stream().filter(t -> t.getUrlclass().equals(className)).collect(Collectors.toList());
		return urlPublishs;
	}

	@Override
	public PublishList fetchAllTopics() throws EBPublisherAPIException {
		File file = XmlParserUtility.getFile();
		PublishList publishList= XmlParserUtility.parseXML(file);
		return publishList;
	}
}
