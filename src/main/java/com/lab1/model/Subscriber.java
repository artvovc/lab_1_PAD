package com.lab1.model;

/**
 * Created by Artemie on 03.09.2016.
 */
public class Subscriber {

    private String name;

    private String host;

    private Long port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Subscriber( name=" + this.name + " )";
    }
}
