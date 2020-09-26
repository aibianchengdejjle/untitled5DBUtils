package com.company;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/*
*   使用QueryRunner 完成填入删除和更新
*   都需要用QueryRunner  updata的方法来实现
*   方法中的数据库链接需要传递
* */
public class QueryRunnerupdata {
    private  static Connection c=JDBCUtilsIO.getConnection();
    public static void main(String[] args) throws SQLException {
        //insert();
        //uopdate();
        //delete();

    }

    private static void delete() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="delete from sort where sid=?";
        int row=qr.update(c,sql,(1));
        System.out.println(row);
        DbUtils.closeQuietly(c);
    }

    private static void uopdate() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="update sort set sname=? where sid=?";
        int row=qr.update(c,sql,("LPL"),(7));
        System.out.println(row);
        DbUtils.closeQuietly(c);
    }

    public  static  void insert() throws SQLException {
        //创建一个QueryRunner类的对象
        QueryRunner qr=new QueryRunner();
        //调用QueryRunner的updata方法
        String sql="insert into sort values(?,?)";
        Object []a={null,"lpl"};
        String sql1="select * from sort";
        int row=  qr.update(c,sql,(null),("lpl1"));
        System.out.println(row);
        DbUtils.closeQuietly(c);
    }
}
