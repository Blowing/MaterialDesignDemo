package com.wujie.materialdesigndemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wujie on 2016/8/31.
 */
public class MyDatabaseHelper  extends SQLiteOpenHelper{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "tenda.db";
    private static final String CREATE_TABLE =
            "create table updowninfo "+" ( "
            +" _id " + " integer AUTO_INCREMENT primary key, "
            +" name " + " text not null "
            + ")" ;


    public MyDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        ContentValues cv = new ContentValues();
        cv.put("_id",0);
        cv.put("name", "东东");
        ContentValues cv1 =new ContentValues();
        cv1.put("_id",1);
        cv1.put("name", "男男");
        ContentValues cv2 = new ContentValues();
        cv2.put("_id",2);
        cv2.put("name", "兮兮");
        ContentValues cv3 = new ContentValues();
        cv3.put("_id",3);
        cv3.put("name","北北");
        ContentValues cv4 = new ContentValues();
        cv4.put("_id",4);
        cv4.put("name","北北");
        sqLiteDatabase.insert("updowninfo", null,cv);
        sqLiteDatabase.insert("updowninfo", null,cv1);
        sqLiteDatabase.insert("updowninfo", null,cv2);
        sqLiteDatabase.insert("updowninfo", null,cv3);
        sqLiteDatabase.insert("updowninfo", null,cv4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "updowninfo");
        onCreate(sqLiteDatabase);
    }
}
