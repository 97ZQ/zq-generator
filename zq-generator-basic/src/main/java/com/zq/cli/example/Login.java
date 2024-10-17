package com.zq.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {
//交互式使用Callable
    @Option(names = {"-u","--user"},description = "User name")
    String user;

    @Option(names = {"-p","--password"},description = "Passphrase", arity = "0..1",interactive = true,prompt = "请输入密码")
    String password;

    @Option(names = {"-cp","--checkPassword"},description = "Check Password",arity = "0..1",interactive = true)
    String checkPassword;


    @Override
    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = "+checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u","user123","-p","-cp","xxxx");
    }
}
