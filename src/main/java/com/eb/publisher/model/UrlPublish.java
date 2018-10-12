package com.eb.publisher.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "topicid",
    "urltitle",
    "urlclass"
})
@JacksonXmlRootElement(localName = "url-publish")
public class UrlPublish {

    protected int topicid;
    @XmlElement(required = true)
    protected String urltitle;
    @XmlElement(required = true)
    protected String urlclass;

    /**
     * Gets the value of the topicid property.
     * 
     */
    public int getTopicid() {
        return topicid;
    }

    /**
     * Sets the value of the topicid property.
     * 
     */
    public void setTopicid(int value) {
        this.topicid = value;
    }

    /**
     * Gets the value of the urltitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrltitle() {
        return urltitle;
    }

    /**
     * Sets the value of the urltitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrltitle(String value) {
        this.urltitle = value;
    }

    /**
     * Gets the value of the urlclass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlclass() {
        return urlclass;
    }

    /**
     * Sets the value of the urlclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlclass(String value) {
        this.urlclass = value;
    }

}
