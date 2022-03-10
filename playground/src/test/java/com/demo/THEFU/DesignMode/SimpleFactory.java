package com.demo.theFu.designMode;

import org.junit.jupiter.api.Test;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/4 14:35
 * @description：简单工厂模式
 * @version: 1.0
 */
public class SimpleFactory {

    @Test
    public void test(){
        Chart chart = ChartFactory.createChart("pie");
        chart.display();

    }

}

/**
 * 图表工厂  创建抽象图表具体产品都是通过这个类
 */
class ChartFactory{

    public static Chart createChart(String type){
        Chart chart = null;
        if(type.equalsIgnoreCase("histogram")){
            chart = new HistogramChart();
        }else if(type.equalsIgnoreCase("pie")){
            chart = new PieChart();
        }
        return chart;
    }
}


/**
 * 抽象图表接口
 */
interface Chart{
    void display();
}

/**
 * 柱状图 作为Chart的具体产品类
 */
class HistogramChart implements Chart{

    public HistogramChart(){
        System.out.println("创建柱状图");
    }

    @Override
    public void display() {
        System.out.println("展示柱状图");
    }
}

/**
 * 饼状图 作为Chart的具体产品类
 */
class PieChart implements Chart{

    public PieChart(){
        System.out.println("创建饼状图");
    }

    @Override
    public void display() {
        System.out.println("展示饼状图");
    }
}