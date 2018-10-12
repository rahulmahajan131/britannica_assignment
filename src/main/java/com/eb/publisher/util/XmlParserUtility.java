package com.eb.publisher.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.eb.publisher.exception.EBPublisherAPIException;
import com.eb.publisher.model.PublishList;
import com.eb.publisher.model.UrlPublish;

public class XmlParserUtility {

	private static final Logger LOGGER = LoggerFactory.getLogger(XmlParserUtility.class);

	public static PublishList parseXML(File fileName) throws EBPublisherAPIException {
		PublishList publishList = new PublishList();
		UrlPublish urlPublish = null;

		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
			while (xmlEventReader.hasNext()) {
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("url-publish")) {
						urlPublish = new UrlPublish();
					} else if (startElement.getName().getLocalPart().equals("topicid")) {
						xmlEvent = xmlEventReader.nextEvent();
						urlPublish.setTopicid(Integer.parseInt(xmlEvent.asCharacters().getData()));
					}
					// set the other varibles from xml elements
					else if (startElement.getName().getLocalPart().equals("urltitle")) {
						xmlEvent = xmlEventReader.nextEvent();
						urlPublish.setUrltitle(xmlEvent.asCharacters().getData());
					} else if (startElement.getName().getLocalPart().equals("urlclass")) {
						xmlEvent = xmlEventReader.nextEvent();
						urlPublish.setUrlclass(xmlEvent.asCharacters().getData());
					}
				}
				// if Topic end element is reached, add Topic object to list
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("url-publish")) {
						publishList.getUrlPublish().add(urlPublish);
					}
				}
			}

		} catch (Exception e) {
			LOGGER.error("Failed to process xml: ",e);
			throw new EBPublisherAPIException(e.getLocalizedMessage());
		}
		return publishList;
	}

	public static File getFile() throws EBPublisherAPIException {
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:britannica_topics.xml");
		} catch (FileNotFoundException e) {
			LOGGER.error("Failed to process file:",e);
			throw new EBPublisherAPIException(e.getLocalizedMessage());
		}
		return file;
	}

}
