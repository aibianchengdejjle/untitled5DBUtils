package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection c= JDBCUtilsIO.getConnection();
        String sql="select * from sort";
        PreparedStatement ps=c.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Sort> s=new ArrayList<Sort>();

        while(rs.next())
        {
            Sort s1=new Sort();
            s1.setSname(rs.getString("sname"));
            s.add(s1);
        }
        for (Sort s2:s
             ) {
            System.out.println(s2.getSname());
        }
        JDBCUtils.close(c,ps,rs);
    }
}
