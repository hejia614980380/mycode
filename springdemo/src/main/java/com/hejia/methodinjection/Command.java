package com.hejia.methodinjection;

public interface Command {
    String execute();

    void setState(Object commandState);
}
