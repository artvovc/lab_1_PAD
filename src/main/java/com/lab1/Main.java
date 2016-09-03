package com.lab1;

import com.lab1.reciver.Reciver;
import com.lab1.sender.Sender;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Artemie on 02.09.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, JAXBException, ParserConfigurationException, SAXException, TransformerException {

        Reciver reciver = new Reciver();

        Sender sender = new Sender();
        sender.connectAndSendMsg(false,"lol","privet",null,null);
        sender.connectAndSendMsg(false,"iupii","privet",null,null);
        sender.connectAndSendMsg(false,"bitch","privet",null,null);
        sender.connectAndSendMsg(false,"fuckser","privet",null,null);
        sender.connectAndSendMsg(false,"looser","privet",null,null);

        Thread.currentThread().join();
    }
}
