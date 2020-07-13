LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_LDLIBS := -llog
LOCAL_MODULE := game
LOCAL_SRC_FILES := SoUtil.c

include $(BUILD_SHARED_LIBRARY)