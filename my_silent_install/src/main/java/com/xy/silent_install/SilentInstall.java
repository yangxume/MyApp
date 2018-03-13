package com.xy.silent_install;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/2/9 15:13
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description 静默安装工具类
 * <p>
 * Update records:
 */

public class SilentInstall {

    private static final String TAG = SilentInstall.class.getSimpleName();

    public boolean install(String apkPath) {

        boolean result = false;
        DataOutputStream dataOutputStream = null;
        BufferedReader bufferedReader = null;

        try {
            Process process = Runtime.getRuntime().exec("su");
            dataOutputStream = new DataOutputStream(process.getOutputStream());

            String command = "pm install -r " + apkPath + "\n";

            dataOutputStream.write(command.getBytes(Charset.forName("utf-8")));
            dataOutputStream.flush();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String msg = "";
            String line = "";

            while (bufferedReader.readLine() != null) {
                msg += line;
            }

            Log.d(TAG, "install: " + msg);

            if (!msg.contains("Failure"))
                result = true;

        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "install: " + e.getMessage());
        } finally {
            try {
                if (dataOutputStream != null)
                    dataOutputStream.close();
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                Log.d(TAG, "install: "+e.getMessage());
            }
        }

        return result;

    }

}
