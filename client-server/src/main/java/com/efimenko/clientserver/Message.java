package com.efimenko.clientserver;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Date;
/**
 * Created by DSK20 on 16.12.2015.
 */
public class Message implements Serializable {
    int toId;
    Date date;
    String content;

    public Message (String content) {
        toId = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE-1);
        date = new Date();
        this.content = content;
    }

    public String toString() {
        String string = content+" "+toId+" "+date;
        return string;
    }
}
