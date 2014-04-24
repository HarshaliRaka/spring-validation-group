package com.mvong.example;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvong.example.Form.Group1;
import com.mvong.example.Form.Group2;

@Controller
public class HomeController {

	private static final Logger LOGGER = Logger.getLogger(HomeController.class.getName());
	
	@ModelAttribute("testForm1")
	public Form getForm1() {
		return new Form();
	}

	@ModelAttribute("testForm2")
	public Form getForm2() {
		return new Form();
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome(Model model) {
		return "home";
	}

	@RequestMapping(value = "/validate1", method = RequestMethod.POST)
	public String processGroup1(
			@Validated({ Group1.class }) @ModelAttribute("testForm1") Form form,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			LOGGER.log(Level.INFO, "form1 has errors");
			return "home";
		}
		return "redirect:/home.htm";
	}

	@RequestMapping(value = "/validate2", method = RequestMethod.POST)
	public String processGroup2(
			@Validated({ Group2.class }) @ModelAttribute("testForm2") Form form,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			LOGGER.log(Level.INFO, "form2 has errors");
			return "home";
		}
		return "redirect:/home.htm";
	}
}
