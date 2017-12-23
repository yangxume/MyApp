package com.okay.myapp;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btn01_share_data)
    Button btn01ShareData;
    @BindView(R.id.btn02_send_binary_content)
    Button btn02SendBinaryContent;
    @BindView(R.id.btn03_scrollbarstyle)
    Button btn03Scrollbarstyle;
    @BindView(R.id.btn04_fragment)
    Button btn04Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("My Title");
        toolbar.setSubtitle("Sub Title");

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.icon_navigation);

        toolbar.setOnMenuItemClickListener(onMenuItemClick);
    }

    @OnClick({R.id.btn01_share_data,
            R.id.btn02_send_binary_content,
            R.id.btn03_scrollbarstyle,
            R.id.btn04_fragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn01_share_data:
                toOtherActivity(Activity01_ShareData.class);
                break;
            case R.id.btn02_send_binary_content:
                toOtherActivity(Activity02_Multimedia.class);
                break;
            case R.id.btn03_scrollbarstyle:
                toOtherActivity(Activity03_ScrollBarStyle.class);
                break;
            case R.id.btn04_fragment:
                toOtherActivity(Activity04_Fragment.class);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_edit:
                    msg += "Click edit";
                    break;
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click setting";
                    break;
            }

            if(!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };
}
