package com.example.turntable.util;

import android.util.Log;

public class hnsycsxhzcshUtil {
    private static boolean showLog = true;

    public static void i(Object objTag, Object objMsg) {
        if (showLog) {
            String tag = convertStringTag(objTag);
            String msg = convertStringMsg(objMsg);
            Log.i("LoggerUtil:" + tag, msg);
        }
    }

    /**
     * 把一个Object类型的Tag转换为String类型的Tag
     */
    private static String convertStringTag(Object objTag) {
        String tag;
        if (objTag == null) {
            tag = "null";
            // 如果是String类型，则直接强转
        } else if (objTag instanceof String) {
            tag = (String) objTag;
            // 如果是字节，则取类名
        } else if (objTag instanceof Class) {
            tag = ((Class<?>) objTag).getSimpleName();
            // 取类名
        } else {
            tag = objTag.getClass().getSimpleName();
        }
        return tag;
    }

    /**
     * 把一个Object类型的Msg转换为String类型的Msg
     */
    private static String convertStringMsg(Object objMsg) {
        String msg;
        if (objMsg == null) {
            msg = "null";
        } else {
            msg = objMsg.toString();
        }
        return msg;
    }

    public static void e(Object objTag, Object objMsg) {
        if (showLog) {
            String tag = convertStringTag(objTag);
            String msg = convertStringMsg(objMsg);
            Log.e("LoggerUtil:" + tag, msg);
        }
    }

    public static void e(Object objTag, Object objMsg, Throwable error) {
        if (showLog) {
            String tag = convertStringTag(objTag);
            String msg = convertStringMsg(objMsg);
            Log.e("LoggerUtil:" + tag, msg, error);
        }
    }
}
