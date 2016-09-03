package com.lab1.messagebrocker;

import com.lab1.database.Subscribers;
import com.lab1.dom.util.DomToString;
import com.lab1.model.Subscriber;
import com.lab1.xml.XmlObject;

import javax.xml.bind.JAXBException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Artemie on 03.09.2016.
 */
public class WriteHandler {

    public void SendToAllSubscribers(XmlObject xmlObject) throws IOException, JAXBException {
        for (Subscriber subscriber : Subscribers.getInstance().getData()) {
            Socket subscriberSocketClient = new Socket(subscriber.getHost(), subscriber.getPort().intValue());
            OutputStream out = subscriberSocketClient.getOutputStream();
            DataOutputStream DataSend = new DataOutputStream(out);
            XmlObject tempXmlObject = new XmlObject(
//                isSubscriber,name,msg,host,port
                    xmlObject.getSubscriber(),
                    xmlObject.getName(),
                    xmlObject.getMessage(),
                    xmlObject.getHost(),
                    xmlObject.getPort()
            );
            String str = DomToString.getXmlStringFromObject(XmlObject.class, tempXmlObject);
            byte[] bytes = str.getBytes();
            DataSend.write(bytes, 0, bytes.length);
            out.close();
            DataSend.close();
            subscriberSocketClient.close();
        }
    }

}
