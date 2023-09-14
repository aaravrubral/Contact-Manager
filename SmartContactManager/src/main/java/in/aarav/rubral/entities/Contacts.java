package in.aarav.rubral.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contacts")
public class Contacts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length=10)
	private Integer cId;
	@Column(length=20)
	private String cfName;
	@Column(length=20)
	private String lName;
	@Column(length=15)
	private String work;
	@Column(length=20,unique = true)
	private String cEmail;
	@Column(length=15)
	private String cPhone;
	@Column(length=20)
	private String cImage;
	@Column(length=500)
	private String cDes;
	
	@ManyToOne()
	private User user;
	
	
}
