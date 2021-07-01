package cn.edu.fjzzit.echomusic.dbtext;

import android.database.Cursor;
import android.util.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edu.fjzzit.echomusic.entity.MyInfo;

import static android.content.ContentValues.TAG;

public class UserDao {

    JdbcUtil jdbcUtil = JdbcUtil.getInstance();
    //第一个参数为数据库名称，第二个参数为数据库账号 第三个参数为数据库密码
    Connection conn = jdbcUtil.getConnection("echo_music","music","music");
    //注册
    public boolean register(String name,String password){
        if (conn==null){
            Log.i(TAG,"register:conn is null");
            return true;
        }else {
            //进行数据库操作
            String sql = "insert into userinfo(userName,password,role) values(?,?,'user')";
            try {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1,name);
                pre.setString(2,password);
                return pre.execute();
            } catch (SQLException e) {
                return true;
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //登录
    public boolean login(String name,String password){
        if (conn==null){
            Log.i(TAG,"register:conn is null");
            return false;
        }else {
            String sql = "select * from userinfo where userName=? and password=?";
            try {
                PreparedStatement pres = conn.prepareStatement(sql);
                pres.setString(1,name);
                pres.setString(2,password);
                ResultSet res = pres.executeQuery();
                boolean t = res.next();
                return t;
            } catch (SQLException e) {
                return false;
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*搜索
    insert  into `musicinfo`(`musicId`,`title`,`auther`,`resUrl`) values
    (1,'canon','Johann Pachelbel','canon'),
    (2,'nocturne','Fryderyk','nocturne'),
    (3,'alla turca','Mozart','alla turca');*/
    public void search(List<String> list, String s) {
        if (conn==null){
            Log.i(TAG,"search:conn is null");
        }else {
            String sql = "select * from musicInfo where title like concat('%',?,'%')";
            list.clear();
            try {
                PreparedStatement pres = conn.prepareStatement(sql);
                pres.setString(1, s);
                ResultSet res = pres.executeQuery();
                while (res.next()) {
                    String title = res.getString("title");
                    list.add(title);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //登录
  /*  USE `echo_music`;

    *//*Table structure for table `myinfo` *//*

    DROP TABLE IF EXISTS `myinfo`;

    CREATE TABLE `myinfo` (
      `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
      `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
      `level` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
      `sign` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
      `attention` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
      `dynamic` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
      `fans` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
      `news` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
      KEY `fk_id` (`id`),
      CONSTRAINT `fk_id` FOREIGN KEY (`id`) REFERENCES `userinfo` (`username`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    *//*Data for the table `myinfo` *//*

    insert  into `myinfo`(`id`,`name`,`level`,`sign`,`attention`,`dynamic`,`fans`,`news`) values
    ('101','李四','LV.2','法外狂徒','108','666','10000','500');*/
    public MyInfo getMyInfo(String id){
        MyInfo myInfo = new MyInfo();
        if (conn==null){
            Log.i(TAG,"getMyInfo:conn is null");
        }else {
            String sql = "select * from myinfo where id=?";
            try {
                PreparedStatement pres = conn.prepareStatement(sql);
                pres.setString(1,id);
                ResultSet res = pres.executeQuery();
                while(res.next()){
                    myInfo.setName(res.getString("name"));
                    myInfo.setLevel(res.getString("level"));
                    myInfo.setSign(res.getString("sign"));
                    myInfo.setAttention(res.getString("attention"));
                    myInfo.setDynamic(res.getString("dynamic"));
                    myInfo.setFans(res.getString("fans"));
                    myInfo.setNews(res.getString("news"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return myInfo;
    }

}