package tw.brad.stest5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/main")
@Controller
public class MainController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
}
