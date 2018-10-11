package com.eb.publisher.model;

public class Topic {
	private String topicId;
	private String urlTitle;
	private String urlClass;

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getUrlTitle() {
		return urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}

	public String getUrlClass() {
		return urlClass;
	}

	public void setUrlClass(String urlClass) {
		this.urlClass = urlClass;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", urlTitle=" + urlTitle + ", urlClass=" + urlClass + "]";
	}

}
