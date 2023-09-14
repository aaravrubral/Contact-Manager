package in.aarav.rubral.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private Integer id;
	@Column(length = 20)
	private String fName;
	@Column(length = 20)
	private String lName;
	@Column(length = 25,unique = true)
	private String email;
	@Column(length = 15)
	private String password;
	@Column(length = 15)
	private String confirmPassword;
	
	@Column(length = 15)
	private String role;
	
	private Boolean enable;
	
	@Column(length = 15)
	private String imageUrl;
	
	@Column(length = 500)
	private String about;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Contacts> contact=new ArrayList<>();
	
	
	
}
