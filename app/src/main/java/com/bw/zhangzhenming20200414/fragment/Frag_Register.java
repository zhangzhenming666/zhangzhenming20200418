package com.bw.zhangzhenming20200414.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.zhangzhenming20200414.LoginActivity;
import com.bw.zhangzhenming20200414.R;
import com.bw.zhangzhenming20200414.base.BaseFragment;
import com.bw.zhangzhenming20200414.bean.registerbean.RegisterBean;
import com.bw.zhangzhenming20200414.mvp.mvpregister.IRegisterContract;
import com.bw.zhangzhenming20200414.mvp.mvpregister.RegisterPresenterImpl;

import com.bw.zhangzhenming20200414.net.SpUtil;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class Frag_Register extends BaseFragment<RegisterPresenterImpl> implements IRegisterContract.IRegisterView {
    private EditText registerPhone;
    private EditText registerPwd;
    private Button registerBtn;

    @Override
    public int initLayout() {
        return R.layout.fragment_register;
    }
    @Override
    public void initView() {
        registerPhone = (EditText) view.findViewById(R.id.register_phone);
        registerPwd = (EditText) view.findViewById(R.id.register_pwd);
        registerBtn = (Button) view.findViewById(R.id.register_btn);
    }
    @Override
    public void initListener() {
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = registerPhone.getText().toString().trim();
                String pwd = registerPwd.getText().toString().trim();
                if(!TextUtils.isEmpty(phone)){
                    if(!TextUtils.isEmpty(pwd)){
                        SpUtil.saveString("phone",phone);
                        SpUtil.saveString("pwd",pwd);
                        presenter.getRegister(phone,pwd);
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
    public RegisterPresenterImpl initPresenter() {
        return new RegisterPresenterImpl();
    }
    @Override
    public void onSuccess(RegisterBean registerBean) {
        String message = registerBean.getMessage();
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
        //
        if (getActivity()instanceof LoginActivity){
            //调用activity中刚刚写的方法
            ((LoginActivity)getActivity()).setintent();
        }
    }
    @Override
    public void onError(String msg) {
    }
}
