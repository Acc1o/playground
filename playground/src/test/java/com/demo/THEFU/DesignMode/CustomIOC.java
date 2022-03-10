package com.demo.theFu.designMode;

import com.alibaba.fastjson.JSONObject;
import com.demo.theFu.model.User;
import org.apache.shiro.io.ResourceUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/10 10:11
 * @description：自定义IOC
 * @version: 1.0
 */
public class CustomIOC {

    private static Map<String,Class> classMap = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(CustomIOC.class);

    @Test
    public void test() throws Exception{
        init();
        User user = (User) CustomIOC.getBean("user");
        user.setAge("1");
        user.setName("文武");
        System.out.println(JSONObject.toJSONString(user));
    }

    public static void init(){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(ResourceUtils.getInputStreamForPath("classpath:CustomIOCConfig.xml"));
            NodeList nodeList = document.getElementsByTagName("bean");
            Node item ;
            for(int i = 0 ; i < nodeList.getLength();i++){
                item = nodeList.item(i);
                NamedNodeMap attributes = item.getAttributes();
                Node id = attributes.getNamedItem("id");
                Node value = attributes.getNamedItem("value");
                Class<?> aClass = Class.forName(value.getNodeValue());
                classMap.put(id.getNodeValue(),aClass);
            }
        }catch (Exception e){
            logger.error("自定义IOC初始化失败 》》》》》",e);
        }
    }

    //非单例
    public static Object getBean(String name){
        try{
            return classMap.get(name).newInstance();
        }catch (Exception e){
            logger.error("获取Bean时错误 》》》》》",e);
            return null;
        }
    }
}
