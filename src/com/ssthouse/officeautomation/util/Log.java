package com.ssthouse.officeautomation.util;

/**
 * Created by ssthouse on 01/02/2017.
 */
public class Log {

    private static boolean isDebug = true;

    public static void error(Object msgRoot, String msg) {
        System.out.println(msgRoot.getClass().getName() + ": " + msg);
    }

    public static void error(String msg) {
        System.out.println(msg);
    }

    public static void debug(Object msgRoot, String msg) {
        System.out.println(msgRoot.getClass().getName() + ": " + msg);
    }

    public static void setIsDebug(boolean isDebug) {
        Log.isDebug = isDebug;
    }
}
