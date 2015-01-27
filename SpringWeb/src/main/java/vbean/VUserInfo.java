package vbean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class VUserInfo {
	@NotEmpty(message="아이디는 필수 입력입니다.")
	@Size(min=5,max=6,message="아이디는 5~6자 사이로 입력하세요")
	private String userid;
	@NotEmpty(message="패스워드는 필수 입력입니다.")
	private String password;
	@NotEmpty(message="이름은 필수 입력입니다.")
	private String name;
	@NotEmpty(message="이메일은 필수 입력입니다.")
	@Pattern(regexp="^[_0-9a-zA-Z]+@[0-9a-zA-Z]+(.[_0-9a-zA-Z-]+)*$")
	private String email;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
