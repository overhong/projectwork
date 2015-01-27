package dao;

import java.util.List;
import pbean.Board;
import pbean.UserInfo;

public interface UserDao {
	public UserInfo login(UserInfo userInfo);//로그인

	public List<UserInfo> searchByName(String name);//이름으로 사용자 검색
	
	public void addUser(UserInfo userInfo);//사용자 추가
	
	public List<UserInfo> searchByIdAjax(String userId);
}