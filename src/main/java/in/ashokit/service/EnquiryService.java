package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.DashboardResponse;
import in.ashokit.binding.EnquiryForm;
import in.ashokit.binding.EnquirySearchCriteria;
import in.ashokit.entity.StudentEnqEntity;

public interface EnquiryService {
	
	public List<String> getCourseName();
	
	public List<String> getEnqStatus();
	
	
	public DashboardResponse getDashboardDate(Integer userId);
	
	//public String upsertfEnquiry(EnquiryForm form);
	
	public List<StudentEnqEntity> getEnquiries();
	
	public EnquiryForm getEnquiry(Integer enqId);

	public boolean saveEnquriry(EnquiryForm formObj);


}
