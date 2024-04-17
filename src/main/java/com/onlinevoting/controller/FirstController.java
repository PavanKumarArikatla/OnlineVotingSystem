package com.onlinevoting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

	@RequestMapping("vote")
	public String vote()
	{
		return "beforeLogin.jsp";
	}
}
