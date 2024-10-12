package com.zq.model;

import lombok.Data;

/**
 *  静态模板配置
 */
@Data
public class MainTemplateConfig {

    // 需求：
    // 在代码开头增加作者 @Author注释
    // 修改程序输出的信息提示
    // 将循环读取输入改为单词读取
    /**
     * 作者
     */
    private String author = "zq";

    /**
     * 输出信息
     */
    private String outputText = "输出结果：";
    /**
     * 是否循环
     */
    private boolean loop = false;
}
