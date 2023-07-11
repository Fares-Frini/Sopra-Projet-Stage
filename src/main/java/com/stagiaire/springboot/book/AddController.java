package com.stagiaire.springboot.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddController {

	@GetMapping("/Book")
	public String Book() {
		return"book";
	}
}
