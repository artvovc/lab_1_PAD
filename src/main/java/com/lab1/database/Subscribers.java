package com.lab1.database;

import com.lab1.model.Subscriber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Artemie on 03.09.2016.
 */
public class Subscribers {
    private static Subscribers ourInstance = new Subscribers();

    public static Subscribers getInstance() {
        return ourInstance;
    }

    private List<Subscriber> subscribers = new ArrayList<>();

    private Subscribers() {

    }

    public void add(Subscriber subs) {
        subscribers.add(subs);
    }

    public String getList() {
        String list = "";
        synchronized (list) {
            for (Subscriber subscriber : this.subscribers) {
                list += subscriber.toString() + "\n";
            }
        }
        return list;
    }

    public List<Subscriber> getData(){
        return this.subscribers;
    }

}
