package com.zq.generator;

import com.zq.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator +"MainTemplate.java";

//        D:\project\zq-generator\
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("zq");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(inputPath,outputPath,mainTemplateConfig);


    }

    /**
     * 生成文件
     * @param inputPath
     * @param outputPath
     * @param model
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath,String outputPath,Object model) throws  IOException, TemplateException{
        //new 出Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File templateDir = new File(inputPath).getParentFile();

//        System.out.println(file);
        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(templateDir);
//        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        configuration.setNumberFormat("0.######");

        //创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();

        Template template = configuration.getTemplate(templateName);
        //数据模型


        Writer out = new FileWriter(outputPath);

        template.process(model,out);
        out.close();
    }
}
