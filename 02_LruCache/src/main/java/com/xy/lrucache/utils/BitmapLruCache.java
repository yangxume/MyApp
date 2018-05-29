package com.xy.lrucache.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/5/28 15:14
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
             * https://blog.csdn.net/guolin_blog/article/details/9316683
             * LruCache主要算法原理是把最近使用的对象用强引用存储在 LinkedHashMap 中，
             * 并且把最近最少使用的对象在缓存值达到预设定值之前从内存中移除

 * <p>
 * Update records:
 */
public class BitmapLruCache {

    LruCache<String,Bitmap> mMemoryCache;
    
    public BitmapLruCache(){
        
        //1.获取可用的最大内存大小
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //2.获取缓存大小
        int cacheSize = maxMemory / 8;
        //3.单个图片占用内存大小
        mMemoryCache = new LruCache<String,Bitmap>(cacheSize){

            @Override
            protected int sizeOf(String key, Bitmap bitmap) {

                return bitmap.getByteCount()/1024;

            }
        };
        
    }

    public Bitmap getBitmapFromMemoryCache(String key){
        return mMemoryCache.get(key);
    }

    public void addBitmapToMemoeryCache(String key,Bitmap bitmap){
        if (mMemoryCache.get(key) == null){
            mMemoryCache.put(key,bitmap);
        }
    }

}
