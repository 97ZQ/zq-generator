package com.zq;

import com.zq.cli.CommandExecutor;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,2
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        args= new String[]{"generate","-l","-a","-o"};
//        args= new String[]{"config"};
//        args= new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}