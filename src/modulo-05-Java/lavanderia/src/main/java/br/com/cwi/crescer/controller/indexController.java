package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class indexController {

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("mensagem","Hello World");
		return "index";
	}
}
