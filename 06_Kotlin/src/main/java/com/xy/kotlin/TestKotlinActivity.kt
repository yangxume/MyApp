package com.xy.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button

class TestKotlinActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_kotlin)

        val btn1_test_var_define = findViewById<Button>(R.id.btn1_test_var_define)
        btn1_test_var_define.setOnClickListener(View.OnClickListener {

            Log.e("TestKotlinActivity", " 测试： kotlin")

//            testVarDefine();

            testCanNullVarDefine();
        })



    }

    private fun testLateInit(){

        lateinit var my_button : Button

    }

    private fun testCanNullVarDefine() {

        var var_a : Int ?= 0
        val val_a : Int ?= null

        var_a = 10
//        val_a = 4

        Log.e("KotlinCanNullValdefine","var_a => $var_a \t val_a => $val_a")


    }

    private fun testVarDefine() {

        var var_a : Int = 23;

        var var_b = 13;

        var var_c : Float
        var_c = 11.2f
        var_c += 2;

        Log.d("Kotlin_var_define ","var_a => $var_a \t var_b => $var_b \t var_c => $var_c")

        val val_a : Int = 13;

        val val_b = 39;

        val val_c : Float
        val_c = 19.9f
//        val_c += 3

        Log.d("Kotlin_val_define ","val_a => $val_a \t val_b => $val_b \t val_c => $val_c")

    }


}
