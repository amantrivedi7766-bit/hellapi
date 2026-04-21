# Performance Plan (Practical)

## Target Metrics
- 1% low FPS improve
- Frame-time stutter reduce
- Stable FPS in SMP crowd scenes

## Methods
- Adaptive entity LOD budget
- Chunk mesh queue throttling
- Particle cap by frame budget
- Fire overlay simplification (optional)
- Camera shake dampening (optional)

## Hard Limits
- No universal 200 FPS guarantee.
- No support for forcing Vulkan across all drivers from Java mod alone.
- Different mods/renderers may conflict; compatibility layers are required.
