package com.theFu.designMode;

import org.apache.shiro.io.ResourceUtils;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/10 8:52
 * @description：抽象工厂模式
 * 工厂方法针对的是一种产品，而抽象工厂针对的是一个产品族，增加了概念叫产品等级结构和产品族
 * 产品等级结构：一个抽象接口按钮接口，其子类就有spring按钮 和 summer按钮，位于按钮产品的等级结构中
 * 产品族：spring按钮 spring文本框 spring组合框 同由springSkinFactory工厂创建
 * 用现实生活来说 就类似于 每个公司就相当于一个产品族，每个公司的产品不一样，但多个公司都有同样的产品
 * 但生产的地方不一样 ，这些产品就同在一个产品等级结构中
 * 增加产品族 对于抽象工厂可以很好的支持 “开闭原则”（对于已存在的内容，关闭修改功能，而是向外拓展）
 * 如果增加一个产品 只需要创建具体的产品 并对于新增一个新的具体工厂即可，对于已有代码不做任何修改
 * 如果增加新的产品等级结构，就需要修改所有的工厂角色，违背了 “开闭原则”
 * @version: 1.0
 */
public class AbstractFactoryModel {

    public static Object getBean(){
        try{
            //创建文档对象
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document;
            document = documentBuilder.parse(ResourceUtils.getInputStreamForPath("classpath:AbstractFactoryModelConfig.xml"));
            //获取包含类名的文本节点
            NodeList className = document.getElementsByTagName("className");
            Node firstChild = className.item(0).getFirstChild();
            String nodeValue = firstChild.getNodeValue();
            Class c = Class.forName(nodeValue);
            Object o = c.newInstance();
            return o;
        }catch (Exception ex){
            return new Object();
        }
    }

    @Test
    public void test(){
        //使用抽象层定义
        Button button;
        TextField textField;
        ComboBox comboBox;
        SkinFactory skinFactory;
        skinFactory = (SkinFactory)getBean();
        button = skinFactory.createButton();
        textField = skinFactory.createTextField();
        comboBox = skinFactory.createComboBox();
        button.display();
        textField.display();
        comboBox.display();
    }
}

//按钮接口： 抽象产品
interface Button{
    public void display();
}

//spring按钮类：具体产品
class SpringButton implements Button{
    @Override
    public void display() {
        System.out.println("显示浅绿色按钮。");
    }
}

//summer按钮类：具体产品
class SummerButton implements Button{
    @Override
    public void display() {
        System.out.println("显示浅蓝色按钮。");
    }
}

//文本框接口： 抽象接口
interface TextField{
    public void display();
}

//spring文本框：具体产品
class SpringTextField implements TextField{
    @Override
    public void display() {
        System.out.println("显示绿色边框文本框");
    }
}

//summer文本框：具体产品
class SummerTextField implements TextField{
    @Override
    public void display() {
        System.out.println("显示蓝色边框文本框");
    }
}

//组合框接口：抽象产品
interface ComboBox{
    public void display();
}

//spring组合框：具体产品
class SpringComboBox implements ComboBox{
    @Override
    public void display() {
        System.out.println("显示绿色组合框");
    }
}

//summer组合框：具体产品
class SummerComboBox implements ComboBox{
    @Override
    public void display() {
        System.out.println("显示蓝色组合框");
    }
}

//界面皮肤工厂接口：抽象接口
interface SkinFactory{
    public Button createButton();
    public TextField createTextField();
    public ComboBox createComboBox();
}

//spring界面皮肤工厂: 具体工厂
class SpringSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}

//summer界面皮肤工厂: 具体工厂
class SummerSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}






