package in.ashokit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.DashboardResponse;
import in.ashokit.binding.EnquiryForm;
import in.ashokit.binding.EnquirySearchCriteria;
import in.ashokit.entity.StudentEnqEntity;
import in.ashokit.service.EnquiryService;

@Controller
public class EnquiryController {
	@Autowired
	private EnquiryService enqService;
	@Autowired
	private HttpSession session;
	
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		
		return "index";
	}
	
	
    @GetMapping("/dashboard")
	public String dashBoardPage(Model model) {
    	Integer userId=(Integer)session.getAttribute("userId");
    	DashboardResponse dashboardData = 
    			enqService.getDashboardDate(userId);
    	model.addAttribute("dashboardData", dashboardData);
    	
		
		return "dashboard";
	}
       @PostMapping("addEnq")
      public String addEnquiry(@ModelAttribute("formObj")EnquiryForm formObj,Model model) {
    	   boolean status =enqService.saveEnquriry(formObj);
    	   if(status) {
    		   model.addAttribute("succMsg", "Enquiry Added");
    	   }else {
    		   model.addAttribute("errMsg", "Problem Occured");
    	   }
    	   
    	  return "add-enquiry";
      }
    
    
    
    
    
    @GetMapping("/enquiry")
   	public String addEnquiryPage(Model model) {
    	
    	List<String> courses = enqService.getCourseName();
    	List<String> enqStatuses = enqService.getEnqStatus();
    	EnquiryForm formObj= new EnquiryForm();
    	model.addAttribute("courseNames", courses);
    	model.addAttribute("statusNames", enqStatuses);
    	model.addAttribute("formObj", formObj);
   		
   		return "add-enquiry";
   	}
    private void initForm(Model model) {
    	List<String>courses=enqService.getCourseName(); 
    	List<String> enqStatuses = enqService.getEnqStatus();
    	EnquiryForm formObj=new EnquiryForm();
    	model.addAttribute("courseNames", courses);
    	model.addAttribute("statusNames", enqStatuses);
    	model.addAttribute("formObj", formObj);
    }
    
    @GetMapping("/enquires")
   	public String viewEnquiriesPage(Model model) {
    	initForm(model);
  	model.addAttribute("searchForm", new EnquirySearchCriteria());
  	List<StudentEnqEntity> enquries =  enqService.getEnquiries();
    	model.addAttribute("enquiries", enquries);
   		
   		return "view-enquiries";
   	}
}

