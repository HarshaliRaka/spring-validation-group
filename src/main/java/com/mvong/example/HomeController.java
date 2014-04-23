package com.mvong.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvong.example.Form.Group1;
import com.mvong.example.Form.Group2;

@Controller
@SessionAttributes({ "testForm1", "testForm2" })
public class HomeController {

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
		System.out.println("inside controller");
		return "home";
	}

	@RequestMapping(value = "/validate1", method = RequestMethod.POST)
	public String processGroup1(
			@Validated({ Group1.class }) @ModelAttribute("testForm1") Form form,
			BindingResult result, Model model) {
		System.out.println(result);
		if (result.hasErrors()) {
			System.out.println("error in validation group1");
			return null;
		}
		return "redirect:/home.htm";
	}

	@RequestMapping(value = "/validate2", method = RequestMethod.POST)
	public String processGroup2(
			@Validated({ Group2.class }) @ModelAttribute("testForm2") Form form,
			BindingResult result, Model model) {
		System.out.println(result);
		if (result.hasErrors()) {
			System.out.println("error in validation group2");
			return null;
		}
		return "redirect:/home.htm";
	}
}
