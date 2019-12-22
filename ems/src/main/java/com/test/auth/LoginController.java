package com.test.auth;

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

import com.test.entity.User;

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
 
    @Autowired
    private UserValidator userValidator;
 
    @GetMapping("/register")
    public String registration(Model model) {
    	System.out.println("Inside register");
        model.addAttribute("userForm", new User());
        //ModelAndView mav = new ModelAndView();
        //mav.setViewName("register");
        return "register";
    }
    
    @RequestMapping("/")
	String getHome(Model model) {
		System.out.println("Inside getHome");
		/*ModelAndView mav = new ModelAndView();
		mav.setViewName("login");*/
		return "login";
	}

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "redirect:/homePage";
    }
    
}
