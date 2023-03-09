package com.hejia.methodinjection;

// no more Spring imports!

import org.springframework.beans.factory.annotation.Lookup;

public abstract class CommandManager {

    public Object process(Object commandState) {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        command.setState(commandState);
        return command.execute();
    }

    // okay... but where is the implementation of this method?
//    @Lookup("myCommand")
    @Lookup
    protected abstract Command createCommand();
}


