package com.zhongyi.www.dao;

import java.sql.*;

public class BaseDao {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Hongkong";
    private static String user = "root";
    private static String password = "4906";

    /**
     * 连接数据库
     *
     * @throws Exception
     */
    public static Connection getCon() throws Exception {
        Class.forName(driver);
        System.out.println("加载");
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("连接");
        return con;
    }

    /**
     * 关闭数据库
     */
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {//关闭资源，避免出现异常
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {//关闭资源，避免出现异常
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {//关闭资源，避免出现异常
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
