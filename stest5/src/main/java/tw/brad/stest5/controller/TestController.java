package tw.brad.stest5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/test")
@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		System.out.println(request.getParameter("x"));
		System.out.println(request.getParameter("y"));
		String redirect = String.format("redirect:/test/test2?x=%s&y=%s",
				request.getParameter("x"),
				request.getParameter("y")
				);
		return redirect;
	}

	@GetMapping("/test2")
	public String test2(@RequestParam Integer x, @RequestParam Integer y, Model model) {
		System.out.println(x);
		System.out.println(y);
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		
		
		return "test2";
	}

	@GetMapping("/test3")
	public String test3() {
		
		return "forward:/test/test4";
	}

	@GetMapping("/test4")
	public String test4() {
		return "test4";
	}
	
	
	
}
