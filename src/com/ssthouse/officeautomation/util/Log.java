package com.ssthouse.officeautomation.util;

import com.ssthouse.officeautomation.util.constant.Constant;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * Created by ssthouse on 01/02/2017.
 */
public class Log {

	public static void error(Object msgRoot, String msg) {
		if (!Constant.DEBUG) {
			return;
		}
		System.out.println(msgRoot.getClass().getName() + ": " + msg);
	}

	public static void error(String msg) {
		if (!Constant.DEBUG) {
			return;
		}
		System.out.println(msg);
	}

	public static void debug(Object msgRoot, String msg) {
		if (!Constant.DEBUG) {
			return;
		}
		System.out.println(msgRoot.getClass().getName() + ": " + msg);
	}
}
