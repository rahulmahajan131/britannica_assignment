package com.eb.publisher.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * This Object used to wrap the error message for response when topic not found
 * for requested id.
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 10-12-2018
 */
@JacksonXmlRootElement(localName="url-publish")
public class ErrorTopicResponse {
	private String topicid;
	private String error;
	private String cause;

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

}
