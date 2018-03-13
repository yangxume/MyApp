package com.xy.interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_interface_sense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        commonMethod();
    }

    private void commonMethod() {

        int a = 1;
        int b = 3;
        boolean flag = false;

        if (a == b)
            flag = true;

        String str_a = "str is a";
        String str_b = "str is b";

        if (str_a.equals(str_b))
            flag = false;







    }

    private void initView() {

        btn_interface_sense = findViewById(R.id.btn_interface_sense);
        btn_interface_sense.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_interface_sense:

                break;

        }

    }
}
