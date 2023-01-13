package com.west2.demo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();

            // 开启事务,关闭自动提交事务
            conn.setAutoCommit(false);
            String sql1 ="INSERT INTO class (classid,classname,`time`) VALUES" +
                    "(6,'6班','2021-10-10')," +
                    "(7,'7班','2021-10-11')," +
                    "(8,'8班','2021-10-12')," +
                    "(9,'9班','2021-10-13')," +
                    "(10,'10班','2021-10-14')";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            String sql2 = "UPDATE student SET birthday='2000-03-07' WHERE studentid=001";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            //提交事务
            conn.commit();
            System.out.println("事务完成啦啦啦啦啦啦啦啦~~~~");
        } catch (Exception e) {
            try {
                conn.rollback(); // 失败，则事务回滚
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }

    }
}
