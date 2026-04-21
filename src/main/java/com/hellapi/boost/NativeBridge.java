package com.hellapi.boost;

public final class NativeBridge {
    private static volatile boolean loaded;

    private NativeBridge() {}

    public static boolean load() {
        if (loaded) return true;
        try {
            System.loadLibrary("hellapi_native");
            loaded = true;
            return true;
        } catch (UnsatisfiedLinkError err) {
            loaded = false;
            return false;
        }
    }

    public static float smoothDelta(float rawDelta) {
        if (!loaded) return rawDelta;
        try {
            return nativeSmoothDelta(rawDelta);
        } catch (Throwable ignored) {
            return rawDelta;
        }
    }

    private static native float nativeSmoothDelta(float rawDelta);
}
