package com.ssthouse.officeautomation.util;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.controller.bean.SimpleResultBean;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ResultHelper {

	public static String generateTokenInvalidResult() {
		return new Gson().toJson(new SimpleResultBean(false, "token 过期, 请重新登录"));
	}

	public static String generateSimpleResult(boolean isOk, String msg) {
		return new Gson().toJson(new SimpleResultBean(isOk, msg));
	}
}
