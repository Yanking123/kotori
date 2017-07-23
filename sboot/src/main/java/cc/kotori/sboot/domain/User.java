package cc.kotori.sboot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_test")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="user_name", length=50, updatable=false, unique=true, nullable=false)
	private String username;
	
	@Column(name="pass_word", length=50, nullable=false)
	private String password;
	
	@Column(name="address", length=50)
	private String address;
	
	@Column(name="registe_tate", updatable=false, nullable=false)
	private Date registeTime;

	public User() {
		super();
	}

	public User(Integer id, String username, String password, String address,
			Date registeTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.registeTime = registeTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegisteTime() {
		return registeTime;
	}

	public void setRegisteTime(Date registeTime) {
		this.registeTime = registeTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", address=" + address + ", registeTime="
				+ registeTime + "]";
	}
	
}
