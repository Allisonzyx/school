package com.west2.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            // 获取一个数据库连接
            conn = JdbcUtils.getConnection();

            // 通过conn对象获取负责执行SQL命令的Statement对象
            st = conn.createStatement();

            // 往班级表和学生表里面插入数据
//            String sql ="INSERT INTO class (classid,classname,`time`) VALUES" +
//                    "(1,'1班','2021-10-10')," +
//                    "(2,'2班','2021-10-11')," +
//                    "(3,'3班','2021-10-12')," +
//                    "(4,'4班','2021-10-13')," +
//                    "(5,'5班','2021-10-14')"
            String sql = "INSERT INTO student (studentid,studentname,sex,classid,birthday) VALUES" +
                    "(001,'jack','男',1,'2001-10-10')," +
                    "(002,'roy','男',1,'2001-01-10')," +
                    "(003,'karry','男',2,'2002-07-22')," +
                    "(004,'jack','男',2,'2001-11-16')," +
                    "(005,'jackson','男',2,'2001-10-10')," +
                    "(006,'dsff','女',3,'2003-06-10')," +
                    "(007,'fd','男',3,'2001-10-10')," +
                    "(008,'sdf','女',3,'2005-01-10')," +
                    "(009,'er','男',4,'2008-06-29')," +
                    "(010,'re','女',4,'2001-01-15')," +
                    "(011,'jacerewkson','男',5,'2001-03-10')" +
                    "(012,'rwr','女',5,'2003-06-20')," +
                    "(013,'sdfs','男',1,'2001-10-12')," +
                    "(014,'hgj','男',1,'2001-01-11')," +
                    "(015,'karhgjgry','男',2,'2002-07-13')," +
                    "(016,'jacdgfdk','男',2,'2003-12-14')," +
                    "(017,'fdg','男',2,'2001-04-10')," +
                    "(018,'dfgd','女',3,'2003-04-10')," +
                    "(019,'dgfg','男',3,'2001-12-10')," +
                    "(020,'rer','女',3,'2005-11-10')," +
                    "(021,'rerre','男',4,'2006-06-29')," +
                    "(022,'nbn','女',4,'2001-07-15')," +
                    "(023,'dg','男',5,'2003-11-10')," +
                    "(024,'xv','女',5,'2002-06-20')";



            // 执行操作
            int num = st.executeUpdate(sql);
            if(num>0){
                System.out.println("插入数据成功！！！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JdbcUtils.release(conn,st, rs);
        }
    }
}
