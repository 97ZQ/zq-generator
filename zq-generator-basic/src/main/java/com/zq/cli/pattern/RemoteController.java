package com.zq.cli.pattern;

public class RemoteController {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}
