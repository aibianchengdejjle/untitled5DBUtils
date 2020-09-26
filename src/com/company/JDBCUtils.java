package com.company;

import java.sql.*;

public class JDBCUtils {
    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ljjsb";
            String username = "root";
            String password = "a654320a";
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception var3) {
            throw new RuntimeException(var3 + "数据库连接失败");
        }
    }

    private JDBCUtils() {
    }

    public static Connection getConnection() {
        return con;
    }

    public static void close(Connection con, Statement stat) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException var4) {
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException var3) {
            }
        }

    }

    public static void close(Connection con, Statement stat, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException var6) {
            }
        }

        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException var5) {
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException var4) {
            }
        }
    }
}