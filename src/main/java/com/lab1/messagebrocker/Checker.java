package com.lab1.messagebrocker;

import com.lab1.database.Subscribers;
import com.lab1.model.Subscriber;
import com.lab1.xml.XmlObject;

import java.util.Objects;

/**
 * Created by Artemie on 10.09.2016.
 */
public class Checker {
    public static Boolean check(XmlObject xmlobject){
        for (Subscriber subscriber : Subscribers.getInstance().getData()) {
            if(Objects.equals(subscriber.getName(), xmlobject.getName())) return true;
        }
        return false;
    }
}
