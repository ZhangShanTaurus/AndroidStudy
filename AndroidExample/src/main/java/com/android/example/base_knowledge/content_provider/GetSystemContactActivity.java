package com.android.example.base_knowledge.content_provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;
import com.android.example.main.MyBaseAdapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：GetSystemContactActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class GetSystemContactActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    //获取phone表字段
    private static final String[] PHONES_PROJECTION = {Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID};
    //联系人显示名称字段
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;
    //电话号码
    private static final int PHONES_NUMBER_INDEX = 1;
    //头像id
    private static final int PHONES_PHOTO_ID_INDEX = 2;
    //联系人的id
    private static final int PHONES_CONTACT_ID_INDEX = 3;
    //联系人名称
    private static final List<ContactModel> list = new ArrayList<>();

    private ImageView iv_back;
    private TextView tv_title;
    private ListView listView;
    private SystemContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_system_contact_layout);
        initView();
        initData();
        getPhoneContact();
        getSIMContact();
        if (list.size() > 0) {
            adapter = new SystemContactAdapter(this, list);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 获取手机通讯录联系人信息
     */
    public void getPhoneContact() {
        //获取手机联系人
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                //得到手机号
                String phoneNum = cursor.getString(PHONES_NUMBER_INDEX);
                //当手机号为空或者空白字段，跳过当前循环
                if (TextUtils.isEmpty(phoneNum)) {
                    continue;
                }
                //得到联系人名称
                String contactName = cursor.getString(PHONES_DISPLAY_NAME_INDEX);
                //得到联系人id
                Long contactId = cursor.getLong(PHONES_CONTACT_ID_INDEX);
                //得到联系人头像id
                Long photoId = cursor.getLong(PHONES_PHOTO_ID_INDEX);
                //得到联系人头像Bitmap
                Bitmap contactPhoto = null;
                //photoId 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
                if (photoId > 0) {
                    Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId);
                    InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(resolver, uri);
                    contactPhoto = BitmapFactory.decodeStream(input);
                } else {
                    contactPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.default_head);
                }
                ContactModel contactModel = new ContactModel();
                contactModel.setName(contactName);
                contactModel.setNumber(phoneNum);
                contactModel.setPhoto(contactPhoto);
                list.add(contactModel);
            }
            cursor.close();
        }
    }

    /**
     * 得到手机SIM卡联系人信息
     */
    public void getSIMContact() {
        ContentResolver resolver = getContentResolver();
        //获取SIM卡联系人
        Uri uri = Uri.parse("content://icc/adn");
        Cursor cursor = resolver.query(uri, PHONES_PROJECTION, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                //得到手机号码
                String phoneNumber = cursor.getString(PHONES_NUMBER_INDEX);
                // 当手机号码为空的或者为空字段 跳过当前循环
                if (TextUtils.isEmpty(phoneNumber))
                    continue;
                //得到联系人名称
                String contactName = cursor.getString(PHONES_DISPLAY_NAME_INDEX);
                //SIM卡中没有头像
                ContactModel model = new ContactModel();
                model.setName(contactName);
                model.setNumber(phoneNumber);
            }
            cursor.close();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + list.get(i).getNumber()));
//        startActivity(intent);
    }
}

class SystemContactAdapter extends MyBaseAdapter {
    private List<ContactModel> list;
    private Context context;

    public SystemContactAdapter(Context context, List<ContactModel> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.adapter_system_contact_item, null);
            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            holder.tv_phoneNum = (TextView) view.findViewById(R.id.tv_phoneNum);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_name.setText(list.get(i).getName());
        holder.tv_phoneNum.setText(list.get(i).getNumber());
        holder.imageView.setImageBitmap(list.get(i).getPhoto());
        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tv_name;
        TextView tv_phoneNum;
    }
}

class ContactModel {
    private String name;//姓名
    private String number;//号码
    private Bitmap photo;//头像

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}