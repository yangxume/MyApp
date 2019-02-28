package com.xy.okhttp_interceptor.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/3/14 11:47
 * <p>
 * ${FILENAME}
 * <p>
 * Description 文件处理工具类
 * <p>
 * Update records:
 */

public class FileUtils {

    private static final int     BUFFER_SIZE = 1024;

    /**
     * Copy resources from assets to application data folder
     *
     * @param context
     *          the application context
     */
    public static void copyAssets(Context context)
    {
        try
        {
            File path = context.getDir("Data", 0);

            //copy ink files
            String[] assetsFiles = context.getAssets().list("ink");

            for (String assetFile : assetsFiles)
            {
                copyAssetsFile("ink", assetFile, path.getPath(), context);
            }

            //copy math resources files
            String[] assetsResourcesDirectories = context.getAssets().list("resources");

            for (String directory : assetsResourcesDirectories)
            {
                String dirPath = path + File.separator + "resources" + File.separator + directory;
                File projDir = new File(dirPath);
                if (!projDir.exists())
                    projDir.mkdirs();

                String[] resourcesFiles = context.getAssets().list("resources" +File.separator +directory);

                for (String assetFile : resourcesFiles)
                {
                    copyAssetsFile("resources" + File.separator + directory, assetFile, new File(dirPath + File.separator).getPath(), context);
                }
            }

        }
        catch (IOException e)
        {
            LogUtils.d("copy assets has exception");

            throw new RuntimeException("copy assets has exception");
        }
    }

    /**
     * Copy a file from the assets to the sdcard.
     *
     * @param filename
     *          the file to copy
     * @param dest
     *          the destination to copy
     * @param context
     *          parent application context
     * @throws IOException
     *           error during the copy
     */
    public static void copyAssetsFile(final String assetsDir, final String filename, final String dest, final Context context) throws IOException
    {
        final String newFileName = dest + "/" + filename;

        final AssetManager assetManager = context.getAssets();
        final byte[] buffer = new byte[BUFFER_SIZE];
        final InputStream in = assetManager.open(assetsDir +"/" + filename);
        final OutputStream out = new FileOutputStream(newFileName);
        int read;
        while ((read = in.read(buffer)) != -1)
            out.write(buffer, 0, read);
        in.close();
        out.flush();
        out.close();
    }

    /**
     * 保存到SD卡
     * @param filename
     * @param filecontent
     * @throws Exception
     */
    public static void saveToSDCard(String inkFilePath ,String filename, String filecontent){
        File file = new File(inkFilePath,filename);

        if(file.exists())
            file.delete();

        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outStream.write(filecontent.getBytes());
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
