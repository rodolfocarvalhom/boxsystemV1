package br.com.boxsystemV1.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String irParahome(){
		return "index";
	}
	
}
