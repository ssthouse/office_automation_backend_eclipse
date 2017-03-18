package com.ssthouse.officeautomation.util;

import com.ssthouse.officeautomation.domain.UserEntity;

public class BeanValidator {

	public static boolean isValidate(UserEntity userEntity){
		if (userEntity == null) {
			return false;
		}
		if (StringUtil.isEmpty(userEntity.getUsername())) {
			return false;
		}
		if (StringUtil.isEmpty(userEntity.getPassword())) {
			return false;
		}
		return true;
	}
}
