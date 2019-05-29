package com.xy.android_mvp.login.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xy.android_mvp.R;
import com.xy.android_mvp.login.ContractInterface;
import com.xy.android_mvp.login.persenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ContractInterface.ILoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    LinearLayout back;
    @BindView(R.id.login)
    LinearLayout login;
    private Context ctx;

    @BindView(R.id.status_bar)
    View statusBar;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setData();

    }

    private void setData() {
        this.loginPresenter = new LoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassWord() {
        return etPassword.getText().toString();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(ctx, "login success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(ctx, "login failed", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.btn_login:

                this.loginPresenter.login();

                break;
        }
    }

}
