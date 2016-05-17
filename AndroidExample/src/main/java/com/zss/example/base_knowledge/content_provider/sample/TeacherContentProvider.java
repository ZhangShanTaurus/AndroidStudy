package com.zss.example.base_knowledge.content_provider.sample;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

/**
 * 描述：TeacherContentProvider:这个类给外部程序提供访问内部数据的一个接口
 * Created by Administrator on 2016/2/29 0029.
 */
public class TeacherContentProvider extends ContentProvider {
    private final String TAG = "ContentProvider";
    private DBOpenHelper dbOpenHelper;
    // UriMatcher类用来匹配Uri，使用match()方法匹配路径时返回匹配码
    private UriMatcher uriMatcher = ConstantData.UserTableData.uriMatcher;

    /**
     * 是一个回调函数，在ContentProvider创建的时候，就会运行,第二个参数为指定数据库名称，如果不指定，就会找不到数据库；
     * 如果数据库存在的情况下是不会再创建一个数据库的。（当然首次调用 在这里也不会生成数据库必须调用SQLiteDatabase的 getWritableDatabase,getReadableDatabase两个方法中的一个才会创建数据库）
     */
    @Override
    public boolean onCreate() {
        //这里会调用 DBOpenHelper的构造函数创建一个数据库；
        dbOpenHelper = new DBOpenHelper(this.getContext(), ConstantData.DATABASE_NAME, ConstantData.DATABASE_VERSION);
        return true;
    }

    @Override
    public String getType(Uri uri) {
        Log.e(TAG, "getType()");
        switch (uriMatcher.match(uri)) {
            case ConstantData.UserTableData.TEACHERS:
                return ConstantData.UserTableData.CONTENT_TYPE;
            case ConstantData.UserTableData.TEACHER:
                return ConstantData.UserTableData.CONTENT_TYPE_ITEM;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    /**
     * 当执行这个方法的时候，如果没有数据库，他会创建，同时也会创建表，但是如果没有表，下面在执行insert的时候就会出错
     * 这里的插入数据也完全可以用sql语句书写，然后调用 db.execSQL(sql)执行。
     */
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.e(TAG, "insert()");
        //获得一个可写的数据库引用，如果数据库不存在，则根据onCreate的方法里创建；
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        long id = 0;
        switch (uriMatcher.match(uri)) {
            case ConstantData.UserTableData.TEACHERS:
                id = db.insert("teacher", null, contentValues);    // 返回的是记录的行号，主键为int，实际上就是主键值
                return ContentUris.withAppendedId(uri, id);
            case ConstantData.UserTableData.TEACHER:
                id = db.insert("teacher", null, contentValues);
                String path = uri.toString();
                return Uri.parse(path.substring(0, path.lastIndexOf("/")) + id); // 替换掉id
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.e(TAG, "query()");
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        switch (uriMatcher.match(uri)) {
            case ConstantData.UserTableData.TEACHERS:
                return db.query("teacher", projection, selection, selectionArgs, null, null, sortOrder);
            case ConstantData.UserTableData.TEACHER:
                // 进行解析，返回值为10
                long personid = ContentUris.parseId(uri);
                String where = "_ID=" + personid;// 获取指定id的记录
                where += !TextUtils.isEmpty(selection) ? " and (" + selection + ")" : "";// 把其它条件附加上
                return db.query("teacher", projection, where, selectionArgs, null, null, sortOrder);
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Log.e(TAG, "update()");
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case ConstantData.UserTableData.TEACHERS:
                count = db.update("teacher", values, selection, selectionArgs);
                break;
            case ConstantData.UserTableData.TEACHER:
                // 下面的方法用于从URI中解析出id，对这样的路径content://com.ljq.provider.personprovider/person/10
                // 进行解析，返回值为10
                long personid = ContentUris.parseId(uri);
                String where = "_ID=" + personid;// 获取指定id的记录
                where += !TextUtils.isEmpty(selection) ? " and (" + selection + ")" : "";// 把其它条件附加上
                count = db.update("teacher", values, where, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        db.close();
        return count;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.e(TAG, "delete()");
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case ConstantData.UserTableData.TEACHERS:
                count = db.delete("teacher", selection, selectionArgs);
                break;
            case ConstantData.UserTableData.TEACHER:
                // 下面的方法用于从URI中解析出id，对这样的路径content://hb.android.teacherProvider/teacher/10
                // 进行解析，返回值为10
                long personid = ContentUris.parseId(uri);
                String where = "_ID=" + personid;   // 删除指定id的记录
                where += !TextUtils.isEmpty(selection) ? " and (" + selection + ")" : "";   // 把其它条件附加上
                count = db.delete("teacher", where, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        db.close();
        return count;
    }
}
