package com.lab1.reciver;

import com.lab1.sender.Sender;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutionException;

/**
 * Created by Artemie on 02.09.2016.
 */
public class Reciver extends Sender {

    public Reciver() throws IOException, InterruptedException, ExecutionException, TransformerException, SAXException, JAXBException, ParserConfigurationException {
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(null);
        server.bind(new InetSocketAddress("localhost",5151));
        Attachment attachment = new Attachment();
        attachment.setServer(server);
        this.connectAndSendMsg(true,"Vasile",null,"localhost",5151L);
        server.accept(attachment,new ConnectionHandler());
        Thread.currentThread().join();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TransformerException, IOException, JAXBException, ParserConfigurationException, SAXException {
        Reciver reciver = new Reciver();
    }


}
