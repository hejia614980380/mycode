package com.hejia.methodinjection;

public class AsyncCommand implements Command {
    @Override
    public String execute() {
        return "AsyncCommand";
    }

    @Override
    public void setState(Object commandState) {

    }
}
