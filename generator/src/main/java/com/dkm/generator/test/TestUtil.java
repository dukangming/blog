package com.dkm.generator.test;

/**
 * @author dkm
 * @create 2020-08-05 10:53
 */
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestUtil {

    static String ftlPath = "generator\\src\\main\\java\\com\\dkm\\generator\\test\\";
    static String toPath = "generator\\src\\main\\java\\com\\dkm\\generator\\test\\";

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        Template temp = cfg.getTemplate("test.ftl");

        FileWriter fw = new FileWriter(toPath + "Test.java");
        BufferedWriter bw = new BufferedWriter(fw);
        temp.process(null, bw);
        bw.flush();
        fw.close();
    }
}
