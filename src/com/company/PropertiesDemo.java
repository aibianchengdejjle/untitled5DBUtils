package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Callable;

/*
*   加载配置文件
*   IO读取文件，键值对存储到集合
*   从集合中以键值对方式获取数据库的链接信息
* */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //因为发布的东西不会带有src所有要用新的读取方式
        //FileInputStream fis=new FileInputStream("src/database.properties");
        //要用类的加载器进行读取 读取的信息是io流信息
      InputStream is= PropertiesDemo.class.getClassLoader().getResourceAsStream("database.properties");
       // System.out.println(is);
        // Properties以key=value 的 键值对的形式进行存储值。 key值不能重复。
        Properties p=new Properties();
        //已经对其完成了io读写
        p.load(is);
        String driver=p.getProperty("driverClass");
        String url=p.getProperty("url");
        String name=p.getProperty("username");
        String password=p.getProperty("password");
        Class.forName(driver);
        Connection c= DriverManager.getConnection(url,name,password);
    }
}
