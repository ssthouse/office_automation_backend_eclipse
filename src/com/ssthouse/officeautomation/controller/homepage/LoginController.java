package com.ssthouse.officeautomation.controller.homepage;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.controller.bean.TokenResultBean;
import com.ssthouse.officeautomation.controller.homepage.bean.UserBean;
import com.ssthouse.officeautomation.dao.impl.UserDaoImpl;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.Log;
import com.ssthouse.officeautomation.util.StringUtil;

@Controller
@RequestMapping("/")
public class LoginController {

	@CrossOrigin
	@RequestMapping("/token")
	public void getToken(HttpServletRequest request, HttpServletResponse response,
			@RequestBody UserBean requestUserBean) {
		if (requestUserBean == null || StringUtil.isEmpty(requestUserBean.getUsername())
				|| StringUtil.isEmpty(requestUserBean.getPassword())) {
			sendTokenResultBean(response, false, "");
			return;
		}
		// 尝试获取用户 Entity
		UserDaoImpl userDaoImple = new ClassPathXmlApplicationContext("spring.xml").getBean(UserDaoImpl.class);
		UserEntity userEntity = userDaoImple.getUserEntity(requestUserBean.getUsername(), requestUserBean.getPassword(),
				requestUserBean.getIsAdmin());
		boolean loginReault = false;
		loginReault = (userEntity != null);
		if (loginReault == false) {
			sendTokenResultBean(response, false, "");
			return;
		}
		String token = TokenManager.getToken(requestUserBean.getUsername());
		sendTokenResultBean(response, true, token);
	}

	private void sendTokenResultBean(HttpServletResponse response, boolean success, String token) {
		try {
			if (success) {
				response.getWriter().print(new Gson().toJson(new TokenResultBean(success, token)));
			} else {
				response.getWriter().print(new Gson().toJson(new TokenResultBean(success, "")));
			}
		} catch (IOException e) {
			Log.error("send token result bean fail!");
			e.printStackTrace();
		}
	}
}
