#include <jni.h>
#include <string>
#include <oboe/Oboe.h>
#include "AudioEngine.h"

static AudioEngine *engine = nullptr;

extern "C" JNIEXPORT jstring JNICALL
Java_aleksei_vasilev_oboelib_OboeLib_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_aleksei_vasilev_oboelib_OboeLib_createEngine(JNIEnv *env, jobject _) {
    if (engine == nullptr) {
        engine = new AudioEngine();
    }
    return (engine != nullptr) ? JNI_TRUE : JNI_FALSE;
}

extern "C"
JNIEXPORT void JNICALL
Java_aleksei_vasilev_oboelib_OboeLib_setDefaultStreamParameters(JNIEnv *env, jobject thiz,
                                                                jint sample_rate,
                                                                jint frames_per_burst) {
    oboe::DefaultStreamValues::SampleRate = (int32_t) sample_rate;
    oboe::DefaultStreamValues::FramesPerBurst = (int32_t) frames_per_burst;
}