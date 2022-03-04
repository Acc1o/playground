package com.demo.THEFU.DesignMode;

import org.junit.jupiter.api.Test;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/4 15:32
 * @description：工厂方法模式
 * 弥补了简单工厂模式  缺点  ，增加新产品 无须修改抽象工厂 和 抽象产品的接口 ，
 * 也无须修改具体工厂和具体产品，只需要再新增一个工厂和接口就可以了，完全符合“开闭原则”
 * 缺点：每增加一个产品 就要成对增加类，增加了系统复杂度和系统开销
 * @version: 1.0
 */
public class PatternOfFactoryMethod {
    @Test
    public void test(){
        LoggerFactory loggerFactory = new DataBaseLoggerFactory();
        Logger logger = loggerFactory.createLogger();
        logger.writeLog();
    }

}
/**
 * 抽象日志接口
 */
interface Logger{
    void writeLog();
}

/**
 * 数据库日志 作为日志的具体产品类
 */
class DataBaseLogger implements Logger{

    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}

/**
 * 文件日志 作为日志的具体产品类
 */
class FileLogger implements Logger{

    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}

interface LoggerFactory{
    Logger createLogger();
}

class DataBaseLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new DataBaseLogger();
    }
}

class FileLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}