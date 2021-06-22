package cn.edu.fjzzit.echomusic.dbtext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// SQLlite数据库创建
public class DBHelper extends SQLiteOpenHelper {
    final String CREATE_TABLE = "create table IF not EXISTS musicInfo (" +
            "musicId Integer primary key autoincrement," +
            "title varchar(50)," +
            "auther varchar(50)," +
            "resUrl varchar(50)"  + ")";
    private Context mContext;
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
