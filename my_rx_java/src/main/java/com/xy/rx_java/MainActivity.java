package com.xy.rx_java;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test2();


    }

    public void test2(){

        final List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a1");
        list.add("a2");

        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<String>> e) throws Exception {
                e.onNext(list);
            }
        })
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e("zhao", "onSubscribe: " + d.isDisposed());
                    }

                    @Override
                    public void onNext(@NonNull List<String> integer) {
                        Log.e("zhao", "onNext: " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("zhao", "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("zhao", "onComplete: ");
                    }
                });
    }

    public void test(){

//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                //TODO 在此处进行网络请求的操作
//                return "hhha";
//
//            }
//        }).subscribeOn(Schedulers.io()) //指定被观察者中的方法在io线程中进行处理
//                .observeOn(AndroidSchedulers.mainThread()) //指定观察者接收数据在主线程中
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        //TODO 在此处主线程中进行UI的更新
//                        android.widget.Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

    }
}
