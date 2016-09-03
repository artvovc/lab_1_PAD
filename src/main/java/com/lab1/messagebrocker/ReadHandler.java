package com.lab1.messagebrocker;

import com.lab1.database.Subscribers;
import com.lab1.dom.util.StringToDom;
import com.lab1.model.Subscriber;
import com.lab1.xml.XmlObject;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.Date;

class ReadHandler implements CompletionHandler<Integer, Attachment> {
    @Override
    public void completed(Integer result, Attachment attachment) {
        attachment.getBuffer().flip();
        int limits = attachment.getBuffer().limit();
        byte bytes[] = new byte[limits];
        attachment.getBuffer().get(bytes, 0, limits);
        attachment.getBuffer().rewind();
        Charset cs = Charset.forName("UTF-8");
        String msg = new String(bytes, cs);
        XmlObject xmlObject = null;
        try {
            xmlObject = (XmlObject) StringToDom.getObjectFromXmlString(XmlObject.class,msg);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Subscriber subs = new Subscriber();
        subs.setName(xmlObject.getName());
        if(xmlObject.getSubscriber()) {
            subs.setHost(xmlObject.getHost());
            subs.setPort(xmlObject.getPort());
            Subscribers.getInstance().add(subs);
        }

        System.out.println(xmlObject);

        WriteHandler writer = new WriteHandler();

        try {
            writer.SendToAllSubscribers(xmlObject);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void failed(Throwable e, Attachment attachment) {
        e.printStackTrace();
    }
}