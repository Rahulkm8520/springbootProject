package in.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "AIT_STUDENT_ENQURIES")
public class StudentEnqEntity {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "USER_SEQUENCE")
	// @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQUENCE", allocationSize = 10)

     private Integer enqueryId;
     private  String studentName;
     private Integer phno;
     private String classMode;
     private  String courseName;
     private  String enqueryStatus;
     private  String createdDate;
     private  String updateDate;
     
     @ManyToOne
     @JoinColumn(name= "user_Id")
     
     private UserDtlsEntity user;
   
}
