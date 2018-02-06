// HelloWorld.c

#include "com_xy_jni_HelloWorld.h"

#ifdef __cplusplus
extern "C"
{
#endif

/*
 * Class:     Java_com_xy_jni_HelloWorld_sayHello
 * Method:    sayHello
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_xy_jni_HelloWorld_sayHello(
        JNIEnv *env, jclass cls, jstring j_str)
{
    const char *c_str = NULL;
    char buff[128] = { 0 };
    c_str = (*env)->GetStringUTFChars(env, j_str, NULL);
    if (c_str == NULL)
    {
        printf("out of memory.\n");
        return NULL;
    }
    (*env)->ReleaseStringUTFChars(env, j_str, c_str);
    printf("Java Str:%s\n", c_str);
    sprintf(buff, "hello %s", c_str);
    return (*env)->NewStringUTF(env, buff);
}

#ifdef __cplusplus
}
#endif