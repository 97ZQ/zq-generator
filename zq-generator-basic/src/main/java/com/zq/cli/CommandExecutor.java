package com.zq.cli;

import com.zq.cli.command.ConfigCommand;
import com.zq.cli.command.GenerateCommand;
import com.zq.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "zq" ,mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine;

    //无论执行多少次命令，使用的commandLine都是一样的
    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 --help 命令提示");
    }


    public Integer doExecute(String[] args){
        return commandLine.execute(args);
    }
}
