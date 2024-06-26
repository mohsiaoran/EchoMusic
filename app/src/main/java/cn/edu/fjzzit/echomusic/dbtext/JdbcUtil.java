package cn.edu.fjzzit.echomusic.dbtext;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtil {
    private static JdbcUtil instance;

    public static JdbcUtil getInstance(){
        if (instance ==null){
            instance = new JdbcUtil();
        }
        return instance;
    }
    //目前用到的是第一个  ip地址改成自己的127.0.0.1 192.168.124.9 10.0.2.2
    public Connection getConnection(String dbName,String name,String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.2.123:3307/"+dbName;
            return DriverManager.getConnection(url,name,password);
        } catch (Exception e) {
            return null;
        }
    }

    //第二个是为了更加方便，直接把数据库相关信息写到文件通过文件找到相应的账号密码以及url
    public Connection getConnection(String file){
        File f = new File(file);
        if(!f.exists()){
            return null;
        }else {
            Properties pro = new Properties();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                pro.load(new FileInputStream(f));
                String url = pro.getProperty("url");
                String name = pro.getProperty("name");
                String password = pro.getProperty("password");
                return DriverManager.getConnection(url,name,password);
            }catch (Exception e){
                return null;
            }
        }
    }
}
