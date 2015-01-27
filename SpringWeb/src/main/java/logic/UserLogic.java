package logic;

import java.util.List;

import pbean.UserInfo;
import vbean.VUserInfo;

public interface UserLogic {//로그인
	public UserInfo login(VUserInfo userInfo);
	
	public List<UserInfo> searchByName(String name);
	
	public void addUser(VUserInfo userInfo);
	
	public List<UserInfo> searchByIdAjax(String userid);
	
}
