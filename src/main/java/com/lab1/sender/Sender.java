package com.lab1.sender;


import com.lab1.xml.XmlObject;
import com.lab1.dom.util.DomToString;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutionException;

/**
 * Created by Artemie on 02.09.2016.
 */
public class Sender {

    public static void main(String[] args) throws SAXException, InterruptedException, ExecutionException, TransformerException, IOException, JAXBException, ParserConfigurationException {
        Sender sender = new Sender();
        sender.connectAndSendMsg(false,"lol","privet",null,null);
        sender.connectAndSendMsg(false,"iupii","privet",null,null);
        sender.connectAndSendMsg(false,"bitch","privet",null,null);
        sender.connectAndSendMsg(false,"fuckser","privet",null,null);
        sender.connectAndSendMsg(false,"looser","privet",null,null);
    }

    public Sender() {
    }

    public void connectAndSendMsg(Boolean isSubscriber,String name, String msg, String host, Long port) throws IOException, ExecutionException, InterruptedException, ParserConfigurationException, SAXException, TransformerException, JAXBException {
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress("localhost", 5051);
        socket.connect(socketAddress);
        OutputStream out = socket.getOutputStream();
        DataOutputStream clientDataSend = new DataOutputStream(out);
        XmlObject xmlObject = new XmlObject(
                isSubscriber,name,msg,host,port
        );
        String str = DomToString.getXmlStringFromObject(XmlObject.class,xmlObject);
        byte[] bytes = str.getBytes();
        clientDataSend.write(bytes,0,bytes.length);
        out.close();
        clientDataSend.close();
        socket.close();

    }
}