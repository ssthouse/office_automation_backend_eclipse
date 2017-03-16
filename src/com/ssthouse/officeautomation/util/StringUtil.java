package com.ssthouse.officeautomation.util;

public class StringUtil {

	
	public static boolean isEmpty(Object strObj){
		if(strObj == null){
			return true;
		}
		if(((String)strObj).length() ==0){
			return true;
		}
		return false;
	}
}
