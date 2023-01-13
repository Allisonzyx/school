package com.west2.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            //删除语句
            String sql = "delete from student where studentid=012";

            int num = st.executeUpdate(sql);
            if(num>0){
                System.out.println("删除数据成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
