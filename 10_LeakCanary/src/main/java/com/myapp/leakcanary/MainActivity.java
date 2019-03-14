package com.myapp.leakcanary;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        getSystemService内存泄漏测试
        canary01GetSystemService();

        canary02Listener();

    }

    private PowerManager powerManager;

    private void canary01GetSystemService() {
        //getSystemService内存泄漏
        powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
    }

    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
    private void canary02Listener(){

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener(){

            @Override
            public void onAudioFocusChange(int focusChange) {

            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();

        reqAudioFocus();
    }

    @Override
    protected void onResume() {
        super.onResume();

        resetAudioFocus();
    }

    private void reqAudioFocus(){

        int i =0;
        do {
            int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                    AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                Log.d(TAG, "I get Audio right: ");
                break;
            }
            i++;
        } while (i < 10);
    }

    private void resetAudioFocus() {
        if (audioManager != null){
            if (onAudioFocusChangeListener != null){
                audioManager.abandonAudioFocus(onAudioFocusChangeListener);
            }
        }
    }

}
