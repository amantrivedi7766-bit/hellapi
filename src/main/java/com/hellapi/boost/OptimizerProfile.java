package com.hellapi.boost;

public record OptimizerProfile(
        String name,
        boolean adaptiveRenderDistance,
        boolean particleLimiter,
        boolean entityBudget,
        boolean asyncChunkPrep,
        int frameWindow
) {
    public static OptimizerProfile loadDefault() {
        return new OptimizerProfile(
                "balanced",
                true,
                true,
                true,
                true,
                120
        );
    }
}
