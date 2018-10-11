package com.eb.publisher.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.eb.publisher.model.Topic;

public class XmlParserUtility {

	public static List<Topic> parseXML(String fileName) {
		List<Topic> topicList = new ArrayList<>();
		Topic topic = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
			while (xmlEventReader.hasNext()) {
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("url-publish")) {
						topic = new Topic();
					}
					else if (startElement.getName().getLocalPart().equals("topicid")) {
						xmlEvent = xmlEventReader.nextEvent();
						topic.setTopicId(xmlEvent.asCharacters().getData());
					}
					// set the other varibles from xml elements
					else if (startElement.getName().getLocalPart().equals("urltitle")) {
						xmlEvent = xmlEventReader.nextEvent();
						topic.setUrlTitle(xmlEvent.asCharacters().getData());
					} else if (startElement.getName().getLocalPart().equals("urlclass")) {
						xmlEvent = xmlEventReader.nextEvent();
						topic.setUrlClass(xmlEvent.asCharacters().getData());
					}
				}
				// if Topic end element is reached, add Topic object to list
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("url-publish")) {
						topicList.add(topic);
					}
				}
			}

		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
		return topicList;
	}
	
}
