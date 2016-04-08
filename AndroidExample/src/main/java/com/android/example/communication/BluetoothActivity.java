package com.android.example.communication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

import java.util.Iterator;
import java.util.Set;

/**
 * 描述：BluetoothActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class BluetoothActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;
    private Button btn_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
        btn_scan = (Button) findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_scan:
                testBluetooth();
                break;
            default:
                break;
        }
    }

    /**
     * 蓝牙
     */
    public void testBluetooth() {
        //得到BluetoothAdapter对象
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //判读bluetoothAdapter对象是否为空，如果为空证明设备没有蓝牙
        if (bluetoothAdapter != null) {
            //判断当前设备蓝牙是否可用
            if (!bluetoothAdapter.isEnabled()) {
                textView.setText("请开启蓝牙设备");
                //如果蓝牙设备不可用的话，提示用户开启蓝牙设备
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(intent);
            }
            //得到所有已经配对的蓝牙适配器对象
            Set<BluetoothDevice> deviceSet = bluetoothAdapter.getBondedDevices();
            if (deviceSet.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder("远程蓝牙地址:\n");
                //用迭代
                for (Iterator iterator = deviceSet.iterator(); iterator.hasNext(); ) {
                    //得到已经配对的蓝牙适配器
                    BluetoothDevice device = (BluetoothDevice) iterator.next();
                    //得到远程蓝牙设备的地址
                    stringBuilder.append(device.getName() + "-" + device.getAddress() + "\n");
                }
                textView.setText(stringBuilder.toString());
            }
        } else {
            //没有蓝牙设备
            textView.setText("没有蓝牙设备");
        }
    }
}
