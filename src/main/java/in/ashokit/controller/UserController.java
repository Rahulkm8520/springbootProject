package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.SignUpForm;
import in.ashokit.binding.UnlockForm;
import in.ashokit.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String signupPage(Model model) {
		model.addAttribute("user", new SignUpForm());	
		return "signup";
	}
	
	@PostMapping("/signup")
	public String handleSingUp(@ModelAttribute("user") SignUpForm form , Model model) {
		
		boolean status =userService.signUp(form);
		
		if(status) {
			
			model.addAttribute("succMsg"," Account Created Check Your Email!!");
		}else {
			
			model.addAttribute("errMsg" ,"Please ..Choose Unique Email");
		}
		return "signup";
	}
	
	
	
	
	
	

	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm")LoginForm loginform ,Model model) {
		
		String status=userService.login(loginform);
		if(status.contains("success")) {
			 return "redirect:/dashboard";  
			/* return "login"; */
		}
		model.addAttribute("errMsg", status);
		
		return "login";
	}
	
	

	@GetMapping("/unlock")
  //	@RequestParam is used to capture the data from Query Parameter
	public String unlockPage(@RequestParam String email, Model model) {
		
		UnlockForm  unlockFormObj =new UnlockForm();
		unlockFormObj.setEmail(email);
		model.addAttribute( "unlock", unlockFormObj);
		
		return "unlock";
	}
	
	//when click on submit method request come on this methods
		@PostMapping("/unlock")
		//@ModelAttribute -> it is used to bind the data 
		public String unlockUserAccount(@ModelAttribute UnlockForm unlock,Model model) {
			
			if(unlock.getNewPwd().equals(unlock.getConfirmPwd())) {
				boolean status=userService.unlockAccount(unlock);
				if(status) {
					 model.addAttribute("succMsg", "Your Account Unlocked Succesfully");
				}else {
					 model.addAttribute("errMsg", "Given Temmprory Password Is Incorrect Check your Email");
					
				}
				
			}else {
				 model.addAttribute("errMsg", "New Password and Confirm, Password Should Be Same");
			}
			 
			
		
			return "unlock"; //after unlock is completed it will return same page	
		}
	
		@GetMapping("/forgot")
		public String forgotPwdPage() {
			
			return "forgotPwd";
		}
		
		@PostMapping("/forgotPwd")
		public String forgotPwd(@RequestParam("email") String email, Model model) {
		    
			boolean status = userService.forgotPwd(email);
			if(status){
				model.addAttribute("succMsg", "Password Send To Your Ragisterd Email ID");
				
			}else {
				model.addAttribute("errMsg", "Invalid Email ID");
				
			}
			
			return "forgotPwd";
		}
	}