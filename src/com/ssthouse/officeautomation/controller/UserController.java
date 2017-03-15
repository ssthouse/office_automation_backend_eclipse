package com.ssthouse.officeautomation.controller;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.dao.UserDaoImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ssthouse on 26/01/2017.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @CrossOrigin
    @RequestMapping("/{username}")
    @ResponseBody
    public String getUserInfo(@PathVariable String username) {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDaoImpl personDAO = context.getBean(UserDaoImpl.class);
		personDAO.test();
        return new Gson().toJson(new UserInfo(username, "22"));
    }

    @CrossOrigin
    @RequestMapping("/{username}/blog/{blogId}")
    @ResponseBody
    public String getUserBlogInfo(@PathVariable String username, @PathVariable int blogId) {
        return String.format("username: %s; blogId: %d", username, blogId);
    }

    @CrossOrigin
    @RequestMapping("/index")
    public String getIndex() {
        return "test";
    }

}
