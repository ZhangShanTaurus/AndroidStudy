package com.zss.example.base_knowledge.fragment.sample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.zss.example.R;

/**
 * 描述：DialogFragmentLogin
 * Created by Administrator on 2016/3/2 0002.
 */
public class DialogFragmentLogin extends DialogFragment {
    private EditText et_name;
    private EditText et_password;

    public interface LoginInputListener {
        void onLoginInputComplete(String username, String password);
    }

    //在onCreateDialog中一般可以使用AlertDialog或者Dialog创建对话框，不过既然google不推荐直接使用Dialog，我们就使用AlertDialog来创建一个登录的对话框
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_fragment_login_layout, null);
        et_name = (EditText) view.findViewById(R.id.et_name);
        et_password = (EditText) view.findViewById(R.id.et_password);
        builder.setView(view)
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LoginInputListener listener = (LoginInputListener) getActivity();
                        listener.onLoginInputComplete(et_name.getText().toString(), et_password.getText().toString());
                    }
                })
                .setNegativeButton("取消", null);
        return builder.create();
    }
}
