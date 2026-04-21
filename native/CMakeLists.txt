cmake_minimum_required(VERSION 3.22)
project(hellapi_native LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_POSITION_INDEPENDENT_CODE ON)

find_package(JNI REQUIRED)

add_library(hellapi_native SHARED src/main/cpp/hellapi_native.cpp)
target_include_directories(hellapi_native PRIVATE ${JNI_INCLUDE_DIRS})
target_link_libraries(hellapi_native PRIVATE ${JNI_LIBRARIES})

target_compile_definitions(hellapi_native PRIVATE HELLAPI_NATIVE_BUILD=1)
