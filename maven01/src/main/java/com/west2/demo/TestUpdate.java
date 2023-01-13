package com.west2.demo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            //更改学生表数据
            String sql = "UPDATE student SET birthday='2000-03-03' WHERE studentid=001";
            int num = st.executeUpdate(sql);
            if(num>0){
                System.out.println("更新数据成功！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
