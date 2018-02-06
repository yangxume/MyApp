//
// Created by xuyang on 18/2/6.
//
#include <jni.h>
#include "com_xy_ndk_MainActivity.h"

#ifdef __cplusplus
extern "C"
{
#endif

JNIEXPORT jstring JNICALL Java_com_xy_ndk_MainActivity_getStringFromJni
  (JNIEnv * env, jclass obj)
  {

    char *str = "Hello ! NDK";
    jstring jstr = (*env)->NewStringUTF(env,str);

    return jstr;

  }

#ifdef __cplusplus
}
#endif