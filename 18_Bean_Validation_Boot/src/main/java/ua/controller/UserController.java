package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.domain.request.RegistrationRequest;
import ua.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@ModelAttribute("user")
	public RegistrationRequest getForm(){
		return new RegistrationRequest();
	}
	
	@GetMapping("/registration")
	public String registration(){
		return "registration";
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("user") RegistrationRequest request, SessionStatus status){
		service.save(request);
		status.setComplete();
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
}
