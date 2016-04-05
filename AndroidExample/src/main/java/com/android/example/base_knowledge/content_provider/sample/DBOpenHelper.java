package com.android.example.base_knowledge.content_provider.sample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * 描述：SQLite操作类DBOpenHelper
 * 这个类继承SQLiteOpenHelper抽象类，用于创建数据库和表。创建数据库是调用它的父类构造方法创建
 * Created by Administrator on 2016/2/29 0029.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private Context context;

    //必须有此构造函数，用来创建一个数据库
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version) {
        //必须通过super()调用父类当中的构造函数
        super(context, name, cursorFactory, version);
    }

    public DBOpenHelper(Context context, String name, int version) {
        this(context, name, null, version);
        this.context = context;
    }

    /**
     * 只有当数据库执行创建的时候才会执行该方法，如果更改表名也不会创建，只有创建数据库的时候，才会创建更改表名之后的数据表
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + ConstantData.UserTableData.TABLE_NAME
                        + "("
                        + ConstantData.UserTableData._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + ConstantData.UserTableData.NAME + " TEXT,"
                        + ConstantData.UserTableData.DATE_ADDED + " INTEGER,"
                        + ConstantData.UserTableData.SEX + " TEXT"
                        + ");"
        );
        Toast.makeText(context, "已创建表" + ConstantData.UserTableData.TABLE_NAME, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
