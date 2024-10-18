package com.zq.generator;

import com.zq.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;


public class MainGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {
        //静态文件生成
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();


        String inputPath = new File(parentFile,"zq-generator-demo-projects/acm-template").getAbsolutePath();
//                projectPath+ File.separator+"zq-generator-demo-projects"+ File.separator+"acm-template";
        String outputPath = projectPath;
        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);
        //动态文件生成


//        String projectPath = System.getProperty("user.dir")+File.separator+"zq-generator-basic";
        String dynamicInputPath = projectPath + File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator +"acm-template/src/com/zq/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(dynamicInputPath,dynamicOutputPath,model);
    }

    public static void main(String[] args) throws TemplateException, IOException {


        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("lspzq");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("我输出辣：");
        doGenerate(mainTemplateConfig);
    }
}
