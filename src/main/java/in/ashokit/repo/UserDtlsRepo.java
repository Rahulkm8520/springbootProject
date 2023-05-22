package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.UserDtlsEntity;

public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity , Integer> {
	
	// for check email is uniqe or predefine in data 
	
	public UserDtlsEntity  findByEmail(String email);
    public UserDtlsEntity findByEmailAndPwd(String email, String pwd);

}
