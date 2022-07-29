package com.iontrading.practice.publisherBeans;

import com.iontrading.talk.api.annotation.Identifier;
import com.iontrading.talk.api.annotation.TalkProperty;
import com.iontrading.talk.api.annotation.TalkType;

/**
 * Created by divya.gupta on 01-08-2018.
 */
@TalkType
public class Trader {

    @Identifier
    @TalkProperty
    private long id;

    @TalkProperty
    private String name;

    public Trader(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @TalkProperty
    public String getName() {
        return this.name;
    }

    public long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Trader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Trader() {
    }
}
