package com.super223.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author superz
 */
public class MybatisGenerator {

    public void generator() throws Exception {

        List<String> warnings = new ArrayList<>();

        File configFile = new File("src/main/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) {

        try {
            MybatisGenerator generatorDisplay = new MybatisGenerator();
            generatorDisplay.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
