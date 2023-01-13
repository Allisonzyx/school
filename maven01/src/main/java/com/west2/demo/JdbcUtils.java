package com.west2.demo;
//工具类
public class JdbcUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    static {
        try{
            //返回输入流
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("resources/db.properties");

            //读取
            Properties properties = new Properties();
            properties.load(inputStream);
            //从db.properties文件中读取出信息
            properties.getProperty("driver");
            properties.getProperty("url");
            properties.getProperty("username");
            properties.getProperty("password");

            //驱动
            Class.forName(driver);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }
    //释放资源
    public static void release(Connection conn, Statement st, ResultSet rs){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}