package com.dkm.generator.server;

import com.dkm.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author dkm
 * @create 2020-08-05 15:08
 */
public class ServerGenerator {

    static String MODULE = "business";
    static String toServicePath = "server\\src\\main\\java\\com\\dkm\\server\\service\\";
    static String toControllerPath = MODULE + "\\src\\main\\java\\com\\dkm\\" + MODULE + "\\controller\\admin\\";
    public static void main(String[] args) throws IOException, TemplateException {


        String Domain = "Section";
        String domain = "section";
        HashMap<String, Object> map = new HashMap<>();
        map.put("Domain",Domain);
        map.put("domain",domain);


        // 生成service
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath + Domain + "Service.java", map);

        // 生成controller
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath + Domain + "Controller.java", map);
    }
}
