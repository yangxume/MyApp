package com.xy.aidl_client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xy.aidl_server.Book;
import com.xy.aidl_server.BookController;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =  "aidl_client";

    private List<Book> bookList;

    private BookController bookController;

    private boolean isConnected;

    private Button btn_getBookList;
    private Button btn_addBook;
    private Button btn_test_bindService;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            bookController = BookController.Stub.asInterface(service);
            Log.d(TAG, "onServiceConnected: ");
            isConnected = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
            isConnected = false;
        }
    };
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        initView();
        bindService();
    }

    private void bindService() {

        intent = new Intent();
        intent.setPackage("com.xy.aidl_server");
        intent.setAction("com.xy.aidl_server.action");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private void initView() {

        btn_getBookList = findViewById(R.id.btn_getBookList);
        btn_addBook = findViewById(R.id.btn_addBook);
        btn_test_bindService = findViewById(R.id.btn_test_bindService);

        btn_getBookList.setOnClickListener(onClickListener);
        btn_addBook.setOnClickListener(onClickListener);
        btn_test_bindService.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btn_getBookList:

                    if (isConnected) {
                        try {
                            bookList = bookController.getBoolList();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        logList();
                    }

                    break;

                case R.id.btn_addBook:

                    break;
                case R.id.btn_test_bindService:

                    Log.d(TAG, "onClick: test_bindService");
                    bindService(intent, connection,Context.BIND_ABOVE_CLIENT);

                    break;

            }

        }
    };

    private void logList() {

        for (Book book : bookList)
            Log.d(TAG, book.getName());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        if (isConnected) {
            unbindService(connection);
        }
    }
}
