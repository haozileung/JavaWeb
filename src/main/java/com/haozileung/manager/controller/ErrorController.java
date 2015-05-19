package com.haozileung.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/errors")
@Controller
public class ErrorController {
	@RequestMapping("/404")
	public void notFound() {
	}

	@RequestMapping("/403")
	public void denied() {
	}

	@RequestMapping("/error")
	public void error() {
	}
}
