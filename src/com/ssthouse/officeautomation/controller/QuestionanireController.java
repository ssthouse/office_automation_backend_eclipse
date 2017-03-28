package com.ssthouse.officeautomation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.controller.cons.ControllerCons;
import com.ssthouse.officeautomation.controller.util.ResultHelper;
import com.ssthouse.officeautomation.dao.IQuestionnaireDao;
import com.ssthouse.officeautomation.dao.impl.QuestionnaireDaoImpl;
import com.ssthouse.officeautomation.domain.QuestionnaireEntity;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.Log;

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
		// TODO save requestion.body to databases
		Log.error(new Gson().toJson(questionnaireEntity));
		return ResultHelper.generateSimpleResult(true, "保存成功");
	}

	@CrossOrigin
	@GetMapping(value = "detail", produces = { ControllerCons.PRODUCES_UTF_8 })
	@ResponseBody
	public String getAllQuestionanire(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		QuestionnaireDaoImpl questionnaireDao = (QuestionnaireDaoImpl) context.getBean(IQuestionnaireDao.class);
		return new Gson().toJson(questionnaireDao.getQuestionnaire());
	}
}
