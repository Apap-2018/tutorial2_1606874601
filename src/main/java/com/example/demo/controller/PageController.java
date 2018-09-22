package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}

	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}

	@RequestMapping(value = { "/challenge", "challenge/{name}" })
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}

	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue="0") String a,
			@RequestParam(value = "b", required = false, defaultValue="0") String b, Model model) {
		
		model.addAttribute("a", a);
		int aa = Integer.parseInt(a);
		
		model.addAttribute("b", b);
		int bb = Integer.parseInt(b);
		
		String res="";
		if(aa == 0 && bb == 0) res = "hm";
		
		else { 
			if(aa == 0) aa++;
			if(bb == 0) bb++;
			
			for(int j=0; j<bb; j++) {
				res = res + "h";
				for(int i=0; i<aa; i++) 
					res = res + "m";
				res = res + " ";
			}
		}
		
		model.addAttribute("res", res);
		
		return "generator";
	}

}
