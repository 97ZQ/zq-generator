package com.zq.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.zq.generator.MainGenerator;
import com.zq.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Data
@Command(name = "generate",mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable {

    /**
     * 是否循环
     */
    @CommandLine.Option(names = {"-l","--loop"},description = "是否循环",arity = "0..1",interactive = true,echo = true)
    private boolean loop = false;

    /**
     * 作者
     */
    @CommandLine.Option(names = {"-a","--author"},description = "作者名称",arity = "0..1",interactive = true,echo = true)
    private String author = "zq";

    /**
     * 输出信息
     */
    @CommandLine.Option(names = {"-o","--outputText"},description = "输出文本",arity = "0..1",interactive = true,echo = true)
    private String outputText = "输出结果：";

    @Override
    public Integer call() {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        try {
            MainGenerator.doGenerate(mainTemplateConfig);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}
