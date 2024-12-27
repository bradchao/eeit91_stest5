package tw.brad.stest5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.brad.stest5.model.Member;

// @RequestMapping("/")
@Controller
public class LoginController {

	@RequestMapping("/register")
	public String reg(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "register";
	}
	
	@PostMapping("/reg_submit")
	public String regSubmit(@ModelAttribute Member member, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors().toString());
			return "register";
		}
		
		System.out.println(member.getAccount());
		System.out.println(member.getPasswd());
		System.out.println(member.getRealname());
		
		return "login";
	}
	
	
}
