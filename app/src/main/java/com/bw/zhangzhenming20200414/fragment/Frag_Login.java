package com.bw.zhangzhenming20200414.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.zhangzhenming20200414.MainActivity;
import com.bw.zhangzhenming20200414.R;
import com.bw.zhangzhenming20200414.base.BaseFragment;
import com.bw.zhangzhenming20200414.bean.loginbean.LoginBean;
import com.bw.zhangzhenming20200414.bean.loginbean.ResultBean;
import com.bw.zhangzhenming20200414.mvp.mvplogin.ILoginContract;
import com.bw.zhangzhenming20200414.mvp.mvplogin.LoginPresenterImpl;

import com.bw.zhangzhenming20200414.net.SpUtil;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class Frag_Login extends BaseFragment<LoginPresenterImpl> implements ILoginContract.ILoginView{
    private android.widget.EditText loginPhone;
    private android.widget.EditText loginPwd;
    private android.widget.Button loginBtn;
    private android.widget.CheckBox ckSave;

    @Override
    public int initLayout() {
        return R.layout.frahment_login;
    }
    @Override
    public void initView() {
        loginPhone = (EditText) view.findViewById(R.id.login_phone);
        loginPwd = (EditText) view.findViewById(R.id.login_pwd);
        loginBtn = (Button) view.findViewById(R.id.login_btn);
        ckSave = (CheckBox) view.findViewById(R.id.ck_save);
    }
    @Override
    public void initListener() {
        boolean ck_save = SpUtil.getBoolean("ckSave");
        if(ck_save){
            ckSave.setChecked(ck_save);
            String phone = SpUtil.getString("phone");
            String pwd = SpUtil.getString("pwd");
            if(!TextUtils.isEmpty(phone)){
                loginPhone.setText(phone);
                loginPwd.setText(pwd);
            }
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = loginPhone.getText().toString().trim();
                String pwd = loginPwd.getText().toString().trim();
                if(!TextUtils.isEmpty(phone)){
                    if(!TextUtils.isEmpty(pwd)){
                        boolean checked = Frag_Login.this.ckSave.isChecked();
                        SpUtil.saveBoolean("ckSave",checked);
                        SpUtil.saveString("phone",phone);
                        SpUtil.saveString("pwd",pwd);
                        presenter.getLogin(phone,pwd);
                    }else{
                        Toast.makeText(getContext(),"账号不能为空",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(),"账号不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void initData() {
    }
    @Override
    public LoginPresenterImpl initPresenter() {
        return new LoginPresenterImpl();
    }
    @Override
    public void onSuccess(LoginBean loginBean) {
        String message = loginBean.getMessage();
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
        ResultBean result = loginBean.getResult();
        String headPic = result.getHeadPic();
        String nickName = result.getNickName();
        int userId = result.getUserId();
        String sessionId = result.getSessionId();
        //存
        SpUtil.saveString("headPic",headPic);
        SpUtil.saveString("nickName",nickName);
        SpUtil.saveString("sessionId",sessionId);
        SpUtil.saveInt("userId",userId);
        //跳转
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
    @Override
    public void onError(String msg) {
    }
}
