package com.hellapi.boost;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * CPU-side frame-time smoother used when native path is unavailable.
 */
public final class FrameTimeSmoother {
    private final DescriptiveStatistics window;

    public FrameTimeSmoother(int sampleWindow) {
        this.window = new DescriptiveStatistics(sampleWindow);
    }

    public float smooth(float rawDelta) {
        window.addValue(rawDelta);

        double p50 = window.getPercentile(50);
        double p90 = window.getPercentile(90);

        double capped = Math.min(rawDelta, p90);
        return (float) ((capped + p50) * 0.5d);
    }
}
