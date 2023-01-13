package com.west2.demo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();

            String sql = "select * from student where id=2";
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println("查询数据成功");
//                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
