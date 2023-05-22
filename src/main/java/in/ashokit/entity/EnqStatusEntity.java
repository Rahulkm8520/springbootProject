package in.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="AIT_ENQUERY_STATUS")
@Data
public class EnqStatusEntity {
	
	@Id
	private Integer statusId;
	private String statusName;

}
