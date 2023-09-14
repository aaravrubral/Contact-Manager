package in.aarav.rubral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.aarav.rubral.entities.User;
import in.aarav.rubral.helper.Message;
import in.aarav.rubral.repo.UserRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "Home - Contact Manager");
		return "home";
	}
	
	
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About - Conatact Manager");
		return "about";
	}
	
	
	@GetMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("title", "Register - Conatact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	// this handler for registering user
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user, 
			                   @RequestParam(value="agreement", defaultValue = "false") 
	                           boolean agreement,Model model, HttpSession session) {
		
		
		try {
		
		if(!agreement) {
			System.out.println("You have not agreed terms and condition");
			throw new Exception("You have not agreed terms and condition");
		}
		user.setRole("ROLE_USER");
		user.setEnable(true);
		user.setImageUrl("dafault.png");
		
		User result=this.userRepo.save(user);
		
		model.addAttribute("user", new User());
		session.setAttribute("Succesfully Registered !!","alert-success");
		return "signup";
		
	    }catch(Exception e){
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something went wrong !!"+e.getMessage(),"alert"));
			return "signup";
		}
	}
}
