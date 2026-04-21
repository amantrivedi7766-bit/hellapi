# HellAPI Vulkan-ish Fabric Mod (Scaffold)

> ⚠️ Reality check: **koi bhi mod guaranteed 200+ FPS har system par lock नहीं कर सकता**. FPS GPU/CPU, drivers, shader packs, resolution, world complexity aur server lag par depend karta hai.

Ye repo ek **safe + realistic scaffold** provide karta hai for Minecraft **1.21.4 + Fabric** jisme:
- Java side optimization hooks
- Native C++ bridge (JNI) for heavy math / batching experiments
- Shell script for local native build
- CI workflow for automated compile checks

## Goals
- Frame-time stability improve karna (stutter kam karna)
- Camera turn, block placement, entity-heavy scenes me spikes reduce karna
- Configurable optimization toggles dena
- Crash-safe fallback (native load fail ho to Java path use kare)

## Non-goals
- Vulkan driver inject karna
- System-level "mobile/PC ke andar jaake boost" type behavior
- 2-3x FPS guarantee on every renderer/shader/modpack

## Quick Start

### 1) Toolchain
- JDK 21
- Gradle 8.10+
- CMake 3.22+
- C++ compiler (clang/gcc/msvc)

### 2) Build Java mod
```bash
./gradlew build
```

### 3) Build native library
```bash
bash scripts/build-native.sh
```

Native output `native/build/` me बनेगा.

## Suggested Optimization Strategy
1. **CPU spikes first**: frustum culling, entity batching, chunk rebuild scheduling.
2. **GC tuning**: object churn कम करना, pooled buffers use करना.
3. **Render settings**: dynamic render distance, particle budget.
4. **Network + SMP**: packet burst smoothing, async decode queues.
5. **Crash safety**: watchdog + fallback path.


## Artifact Size Note
- Is update me shaded math runtime include kiya gaya hai (`commons-math3`) taaki release jar practical tarike se **1MB+** range me ho aur advanced frame-time smoothing possible ho.
- Sirf size badhane ke liye dummy/padding files add nahi kiye gaye; jar size now comes from real runtime functionality.

## CI
GitHub Actions workflow `.github/workflows/ci.yml`:
- Java compile + test task
- Native C++ configure + build

---
Agar tu chahe to next step me main is scaffold me:
- actual mixins,
- Sodium/Iris compatibility guards,
- adaptive quality governor,
- in-game config screen
add kar dunga.
