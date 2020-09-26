package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
*   利用配置文件的方式来读取
*
* */
public class JDBCUtilsIO {
       private  static  Connection c;
    public static void main(String[] args) {

    }
    public  static  Connection getConnection(){
        return c;
    }
    static {
        InputStream is= PropertiesDemo.class.getClassLoader().getResourceAsStream("database.properties");
        // System.out.println(is);
        // Properties以key=value 的 键值对的形式进行存储值。 key值不能重复。
        Properties p=new Properties();
        try {
            p.load(is);
        } catch (IOException e) {
             throw  new RuntimeException(e+"梁家杰傻逼");
        }
        String driver=p.getProperty("driverClass");
        String url=p.getProperty("url");
        String name=p.getProperty("username");
        String password=p.getProperty("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            c= DriverManager.getConnection(url,name,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
