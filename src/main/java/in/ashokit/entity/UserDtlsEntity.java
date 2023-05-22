package in.ashokit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "AIT_USER_DTLS")
@Data
public class UserDtlsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "USER_SEQUENCE")
    private Long userId;
    
    private String name;

    private String email;

    private String pwd;

    private Long phno;

    private String accStatus;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StudentEnqEntity> entities;

    // Add constructors, getters, and setters if needed
}
