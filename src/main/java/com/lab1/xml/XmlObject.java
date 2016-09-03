package com.lab1.xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Artemie on 03.09.2016.
 */
@XmlRootElement
public class XmlObject {

    private Boolean isSubscriber;

    private String name;

    private String message;

    private Long createdDate = new Date().getTime();

    private String host = "";

    private Long port = null;

    public XmlObject() {
    }

    public XmlObject(Boolean isSubscriber, String name, String message) {
        this.isSubscriber = isSubscriber;
        this.name = name;
        this.message = message;
    }

    public XmlObject(Boolean isSubscriber, String name, String message, String host, Long port) {
        this.isSubscriber = isSubscriber;
        this.name = name;
        this.message = message;
        this.createdDate = new Date().getTime();
        this.host = host;
        this.port = port;
    }

    public Boolean getSubscriber() {
        return isSubscriber;
    }

    public void setSubscriber(Boolean subscriber) {
        isSubscriber = subscriber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "XmlObject( isSubscribe = " + isSubscriber +
                ", name = "+ name +
                ", message = "+ message +
                ", createdDate = "+ createdDate +
                ", host = "+ host +
                ", port = "+ port +
                " )";
    }
}
