package com.android.example.base_knowledge.content_provider.sample;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * 描述：常量类
 * 提供ContentProvider对外的各种常量，当外部数据需要访问的时候，就可以参考这些常量操作数据。
 * Created by Administrator on 2016/2/29 0029.
 */
public class ConstantData {
    public static final String AUTHORITY = "hb.android.contentProvider";
    //数据库名
    public static final String DATABASE_NAME = "teacher.db";
    //创建数据库的时候必须加上版本信息，必须大于4
    public static final int DATABASE_VERSION = 4;
    //表名
    public static final String USERS_TABLE_NAME = "teacher";

    public static final class UserTableData implements BaseColumns {
        public static final String TABLE_NAME = "teacher";
        //URI:外部程序需要访问就是通过这个URI访问的，这个URI必须是唯一的
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/teacher");
        //数据集的MIME类型字符串则应该以vnd.android.cursor.dir/开头
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/hb.android.teachers";
        //单一数据的MIME类型字符串应该以vnd.android.cursor.item/开头
        public static final String CONTENT_TYPE_ITEM = "vnd.android.cursor.item/hb.android.teacher";
        //自定义匹配码
        public static final int TEACHERS = 1;
        public static final int TEACHER = 2;

        public static final String NAME = "name";
        public static final String DATE_ADDED = "date_added";
        public static final String SEX = "sex";
        public static final String DEFAULT_SORT_ORDER = "id desc";

        //UriMatcher
        public static final UriMatcher uriMatcher;

        static {
            //常量UriMatcher.NO_MATCH表示不匹配任何路径的返回码
            uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
            //如果match()方法匹配content://hb.android.teacherProvider/teacher路径,返回匹配码为TEACHERS
            uriMatcher.addURI(ConstantData.AUTHORITY, "teacher", TEACHERS);
            //// 如果match()方法匹配content://hb.android.teacherProvider/teacher/230,路径，返回匹配码为TEACHER
            uriMatcher.addURI(ConstantData.AUTHORITY, "teacher/#", TEACHER);
        }
    }

    /**
     * 在创建UriMatcher对象uriMatcher时，我们传给构造函数的参数为UriMatcher.NO_MATCH，它表示当uriMatcher不能匹配指定的URI时，就返回代码UriMatcher.NO_MATCH。
     * 接下来增加了三个匹配规则，分别是:
     * uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
     * uriMatcher.addURI(ContentData.AUTHORITY, "teacher", TEACHERS);
     * uriMatcher.addURI(ContentData.AUTHORITY, "teacher/#", TEACHER);
     * 它们的匹配码分别是teacher.ITEM、teacher.ITEM_ID和teacher.ITEM_POS，其中，符号#表示匹配任何数字。
     * */
}
