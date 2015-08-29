package main.java.entitie;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity 
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String user;
	String password;
	
	@OneToMany (mappedBy="user",fetch = FetchType.EAGER)
	List<AdressEntitie> adress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AdressEntitie> getAdress() {
		return adress;
	}

	public void setAdress(List<AdressEntitie> adress) {
		this.adress = adress;
	}	
	
	
	
}
