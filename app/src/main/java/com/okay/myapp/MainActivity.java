package com.okay.myapp;

import android.graphics.Color;
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

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn01_share_data)
    Button btn01ShareData;
    @BindView(R.id.btn02_send_binary_content)
    Button btn02SendBinaryContent;
    @BindView(R.id.btn03_scrollbarstyle)
    Button btn03Scrollbarstyle;
    @BindView(R.id.btn04_fragment)
    Button btn04Fragment;
    @BindView(R.id.btn05_statusbar_style)
    Button btn05StatusbarStyle;
    @BindView(R.id.btn06_open_source_library)
    Button btn06OpenSourceLibrary;
    @BindView(R.id.btn07_webview)
    Button btn07Webview;
    @BindView(R.id.btn08_viewdraghelper)
    Button btn08Viewdraghelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        // App Logo
        toolbar.setLogo(R.drawable.ic_launcher);
        // Title
        toolbar.setTitle("My Title");
        toolbar.setTitleTextColor(Color.RED);
        // Sub Title
        toolbar.setSubtitle("Sub title");

        setSupportActionBar(toolbar);

        // Navigation Icon 要設定在 setSupoortActionBar 才有作用
        // 否則會出現 back bottom
        toolbar.setNavigationIcon(R.drawable.ab_android);
        // Menu item click 的監聽事件一樣要設定在 setSupportActionBar 才有作用
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
    }

    @OnClick({R.id.btn01_share_data,
            R.id.btn02_send_binary_content,
            R.id.btn03_scrollbarstyle,
            R.id.btn04_fragment,
            R.id.btn05_statusbar_style,
            R.id.btn06_open_source_library,
            R.id.btn07_webview,
            R.id.btn08_viewdraghelper
    })
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
            case R.id.btn05_statusbar_style:
                toOtherActivity(Activity05_StatusBarStyle.class);
                break;
            case R.id.btn06_open_source_library:
                toOtherActivity(Activity06_OpenSourceLibrary.class);
                break;
            case R.id.btn07_webview:
                toOtherActivity(Activity07_WebViewExample.class);
                break;
            case R.id.btn08_viewdraghelper:
                toOtherActivity(Activity08_ViewDragHelper.class);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

            if (!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };
}
