package logic;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import pbean.UserInfo;
import vbean.VUserInfo;

@Service
public class UserLogicImpl implements UserLogic {

   @Autowired
   private UserDao userDao;
   
   @Transactional
   public UserInfo login(VUserInfo vuserInfo) {
   UserInfo userInfo = new UserInfo(vuserInfo);
      return this.userDao.login(userInfo);
   }
 
   @Override
   public List<UserInfo> searchByName(String name) {
	if(name==null || name.equals("")){
		 return Collections.emptyList(); 
   }else {
		 return this.userDao.searchByName(name);
	 }
}
    public void addUser(VUserInfo userInfo) {
	      UserInfo info = new UserInfo(userInfo);
	      this.userDao.addUser(info);
	      
	   }
    @Override
   public List<UserInfo> searchByIdAjax(String userid) {
	      return this.userDao.searchByIdAjax(userid);
	   }



}