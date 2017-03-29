package com.ssthouse.officeautomation.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {
	/**
	 * 在这里处理所有得异常信息
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object o, Exception ex) {
		ex.printStackTrace();
		printWrite("这里是全局异常的处理信息", resp);
		return new ModelAndView();
	}

	/**
	 * 将错误信息添加到response中
	 * 
	 * @param msg
	 * @param response
	 * @throws IOException
	 */
	public static void printWrite(String msg, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(msg);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}