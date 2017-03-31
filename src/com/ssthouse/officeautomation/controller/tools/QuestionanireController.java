package com.ssthouse.officeautomation.controller.tools;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.controller.tools.bean.QuestionnaireAnswerBean;
import com.ssthouse.officeautomation.controller.tools.bean.QuestionnaireResultBean;
import com.ssthouse.officeautomation.controller.tools.bean.QuestionnaireResultBean.Data;
import com.ssthouse.officeautomation.domain.QuestionnaireEntity;
import com.ssthouse.officeautomation.service.IAnswerService;
import com.ssthouse.officeautomation.service.IQuestionnaireService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.Log;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping("/questionnaire")
public class QuestionanireController {

	@CrossOrigin
	@PostMapping(value = "/detail", produces = { ControllerCons.PRODUCES_UTF_8 })
	@ResponseBody
	public String saveQuestionnaire(@RequestBody QuestionnaireEntity questionnaireEntity, HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		if(questionnaireEntity == null || !questionnaireEntity.isValid()){
			return ResultHelper.generateSimpleResult(false, "请求数据不完整");
		}
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IQuestionnaireService service = (IQuestionnaireService) context.getBean(IQuestionnaireService.class);
		service.saveOrUpdateQuestionnaire(questionnaireEntity);
		Log.error(new Gson().toJson(questionnaireEntity));
		return ResultHelper.generateSimpleResult(true, "保存成功");
	}

	@CrossOrigin
	@GetMapping(value = "/detail", produces = { ControllerCons.PRODUCES_UTF_8 })
	@ResponseBody
	public String getAllQuestionanire(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IQuestionnaireService questionnaireService = (IQuestionnaireService) context.getBean(IQuestionnaireService.class);
		List<QuestionnaireEntity> openList = questionnaireService.getOpenQuestionnaireList(request);
		List<QuestionnaireEntity> ownedList = questionnaireService.getOwnedQuestionnaireList(request);
		QuestionnaireResultBean resultBean = new QuestionnaireResultBean(true, "获取问卷数据成功",
				new Data(openList, ownedList));
		return new Gson().toJson(resultBean);
	}
	
	@CrossOrigin
	@PostMapping(value = "/answer", produces={ControllerCons.PRODUCES_UTF_8})
	@ResponseBody
	public String postQuestionnaireAnswer(@RequestBody QuestionnaireAnswerBean questionnaireAnswerBean,
			HttpServletRequest request){
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		//进行问卷结果保存
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IAnswerService service = context.getBean(IAnswerService.class);
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		service.saveAnswer(questionnaireAnswerBean, username);
		Log.error(new Gson().toJson(questionnaireAnswerBean));
		return ResultHelper.generateSimpleResult(true, "问卷提交成功: 后台消息");
	}
	
	@ExceptionHandler  
    @ResponseBody  
    public String handleException(HttpMessageNotReadableException exception) { 
        return ResultHelper.generateSimpleResult(true, "请求数据格式错误");  
    }  
}
