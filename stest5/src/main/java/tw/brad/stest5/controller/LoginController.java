package tw.brad.stest5.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import tw.brad.stest5.model.Member;
import tw.brad.stest5.model.Products;
import tw.brad.stest5.service.MemberService;
import tw.brad.stest5.service.ProductsService;

// @RequestMapping("/")
@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private ProductsService productsService;
	
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping("/register")
	public String reg(Model model) {
		log.debug("debug");
		log.info("mes......");
		log.warn("warnning....");
		log.error("err");
		
		
		Member member = new Member();
		model.addAttribute("member", member);
		return "register";
	}
	
	@PostMapping("/reg_submit")
	public String regSubmit(@ModelAttribute Member member, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors().toString());
			return "register";
		}
		
		log.info("register...{}....{}", member.getAccount(), member.getPasswd());
		
		memberService.addMember(member);
		
		return "login";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("member", new Member());
		return "login";
	}
	
	@PostMapping("/login_submit")
	public String loginSubmit(@ModelAttribute Member member, 
			BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors().toString());
			return "login";
		}
		
		member = memberService.loginMember(member);
		if (member == null){
			return "login";
		}else {
			System.out.println("debug4:" + member.getIconBase64());
			session.setAttribute("member", member);
		}

		model.addAttribute("member", member);
		
		
		List<Products> list = productsService.getProducts();
//		for (Products product:list) {
//			System.out.printf("%s:%s:%s\n", product.getProductname(),
//					product.getUnitprice(), 
//					product.getCategories().getCategoryname());
//		} 
		model.addAttribute("products", list);
		
		return "main";
	}
	
}
