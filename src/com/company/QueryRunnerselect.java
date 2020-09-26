package com.company;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class QueryRunnerselect {
    private  static Connection c= JDBCUtilsIO.getConnection();

    public static void main(String[] args) throws SQLException {
        //ArrayHandler()存储的是第一行数据
       //ArrayListHandler()存储的是每一行的数句
        //beanhandler() 封装成javabean类型
        //ColumnListHandler()适用于放入指定列
        //ScalarHandler();
        //maphandler() 将第一行以键值对的情况装进去
       // maplist()将每一行以map形式装进去
    }

    private static void maplist() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="select * from sort";
        List<Map<String,Object>> lm=qr.query(c,sql,new MapListHandler());
        for (Map<String,Object> m:lm
             ) {
            for (String key:m.keySet()
                 ) {
                //key 是列名
                System.out.print(m.get(key)+" ");
            }
            System.out.println();
        }
    }

    private static void maphandler() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="select * from sort";
        Map<String, Object> m=qr.query(c,sql,new MapHandler());
        for (String key:m.keySet()
             ) {
            System.out.println(key+"    "+m.get(key));
        }
    }

    private static void ScalarHandler() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="select count(*) from sort";
        long row =qr.query(c,sql,new ScalarHandler<Long>());
        System.out.println(row);
    }

    private static void ColumnListHandler() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="select * from sort";
        //将制定的类放入列中
        List<Object> list=qr.query(c,sql,new ColumnListHandler<Object>("sid"));
        for (Object s:
             list) {
            System.out.println(s);
        }
    }

    private static void beanhandler() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="select * from sort";
        Sort s=qr.query(c,sql,new BeanHandler<Sort>(Sort.class));
        System.out.println(s.getSname());
        DbUtils.closeQuietly(c);
    }

    private  static  void  ArrayListHandler() throws  SQLException{
        QueryRunner qr=new QueryRunner();
        String sql="select * from sort";
        List<Object[]>q =qr.query(c,sql,new ArrayListHandler());
        for (Object[] o:q
        ) {
            for (Object s:o
            ) {
                System.out.print(s+"    ");
            }
            System.out.println();
        }
    }
    private static void ArrayHandler() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="select * from sort";
        //执行sql 语句  ArrayHandler()存储的是第一行数据
        Object []o=qr.query(c,sql,new ArrayHandler());
        for (Object q:o
             ) {
            System.out.println(q+"/t");
        }
        DbUtils.closeQuietly(c);
    }

}
