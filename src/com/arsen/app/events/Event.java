package com.arsen.app.events;

import org.jcp.xml.dsig.internal.MacOutputStream;

import java.lang.reflect.Type;

public class Event {

    public enum Type(){
        MOUSE
    }

    protected Event(Type type){

    }
}
