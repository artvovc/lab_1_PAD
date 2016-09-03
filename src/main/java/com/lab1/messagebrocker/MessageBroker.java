package com.lab1.messagebrocker;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * Created by Artemie on 02.09.2016.
 */
public class MessageBroker {
    public static void main(String[] args) throws IOException, InterruptedException {
        MessageBroker messageBroker = new MessageBroker();
    }
    public MessageBroker() throws IOException, InterruptedException {
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(null);
        server.bind(new InetSocketAddress("localhost",5051));
        Attachment attachment = new Attachment();
        attachment.setServer(server);
        server.accept(attachment,new ConnectionHandler());
        Thread.currentThread().join();
    }
}
