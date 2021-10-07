#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_securityman_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++\n implementing the simple NDK is successful";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_securityman_api_ApiClient_getUrl(
        JNIEnv* env,
        jobject /* this */) {
    std::string mUrl = "http://api.androidsupport.ir/";
    return env->NewStringUTF(mUrl.c_str());
}