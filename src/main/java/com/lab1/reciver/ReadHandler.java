package com.lab1.reciver;


import com.lab1.dom.util.StringToDom;
import com.lab1.xml.XmlObject;

import javax.xml.bind.JAXBException;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

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

        System.out.println(xmlObject);


    }

    @Override
    public void failed(Throwable e, Attachment attachment) {
        e.printStackTrace();
    }
}