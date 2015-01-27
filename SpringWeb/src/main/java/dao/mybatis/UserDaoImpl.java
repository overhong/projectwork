package dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import pbean.UserInfo;
import utils.MyBatisManager;
import dao.UserDao;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	public UserInfo login(UserInfo userInfo) {
		return getSqlSession().selectOne("login", userInfo);
	}

	public List<UserInfo> searchByName(String name) {
		return getSqlSession().selectList("searchByName", name);
	}

	public void addUser(UserInfo userInfo) {
	      getSqlSession().insert("addUserInfo", userInfo);
	   }

    public List<UserInfo> searchByIdAjax(String userId) {
	      return getSqlSession().selectList("searchById", userId);
	   }

}