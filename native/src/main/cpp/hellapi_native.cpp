#include <jni.h>

extern "C" JNIEXPORT jfloat JNICALL
Java_com_hellapi_boost_NativeBridge_nativeSmoothDelta(JNIEnv*, jclass, jfloat rawDelta) {
    // Very small smoothing clamp to reduce jitter spikes.
    if (rawDelta < 0.0f) return 0.0f;
    if (rawDelta > 5.0f) return 5.0f;
    return rawDelta;
}
