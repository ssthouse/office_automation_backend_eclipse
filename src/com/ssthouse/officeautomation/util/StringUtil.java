package com.ssthouse.officeautomation.util;

public class StringUtil {

	public static boolean isEmpty(Object strObj) {
		if (strObj == null) {
			return true;
		}
		if (((String) strObj).length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String... args) {
		for (String string : args) {
			if (isEmpty(string)) {
				return true;
			}
		}
		return false;
	}
}
