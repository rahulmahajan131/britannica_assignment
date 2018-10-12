package com.eb.publisher.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="publish-list")
public class PublishList {

	@JacksonXmlProperty(localName = "url-publish")
    protected List<UrlPublish> urlPublish;

    /**
     * Gets the value of the urlPublish property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the urlPublish property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUrlPublish().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PublishList.UrlPublish }
     * 
     * 
     */
    public List<UrlPublish> getUrlPublish() {
        if (urlPublish == null) {
            urlPublish = new ArrayList<UrlPublish>();
        }
        return this.urlPublish;
    }

}
