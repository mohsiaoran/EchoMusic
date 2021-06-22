package cn.edu.fjzzit.echomusic.dbtext;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

// SQLlite数据库操作
public class DBOperate {
    public static cn.edu.fjzzit.echomusic.dbtext.DBOperate dbOperate = null;
    private DBHelper helper;
    private SQLiteDatabase sb;
    private final String TABLE_NAME = "musicInfo";

    public DBOperate(Context context) {
        helper = new DBHelper(context, "musicInfo.db", null, 1);
        sb = helper.getReadableDatabase();
        insertData(1,"canon", "Johann Pachelbel","canon");
        insertData(2, "nocturne","Fryderyk","nocturne");
        insertData(3, "alla turca","Mozart","alla turca");
    }

    //获取数据库操作实例
    public static cn.edu.fjzzit.echomusic.dbtext.DBOperate getDBInstance(Context context) {
        if (dbOperate == null) {
            dbOperate = new cn.edu.fjzzit.echomusic.dbtext.DBOperate(context);
        }
        return dbOperate;
    }

    //读取数据库数据
    public void readData(List<String> list) {
        Cursor cursor = sb.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String musicInfoTitle = cursor.getString(cursor.getColumnIndex("title"));
            list.add(musicInfoTitle);
        }
        cursor.close();
    }

    //根据传入的条件查询
    public void readData(List<String> list, String s) {
        String sql = "select * from musicInfo where title like" + "'%" + s + "%'";
        list.clear();
        Cursor cursor = sb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String musicInfoTitle = cursor.getString(cursor.getColumnIndex("title"));
            list.add(musicInfoTitle);
        }
        cursor.close();
    }

    //插入数据
    public void insertData(Integer musicId, String title, String auther,String resUrl) {
        sb.execSQL("insert INTO musicinfo(musicId,title,auther,resUrl) select ?,?,?,? WHERE NOT EXISTS(SELECT musicId FROM musicinfo WHERE musicId = 1 or 2 or 3)", new Object[]{musicId,title,auther,resUrl});
    }

}