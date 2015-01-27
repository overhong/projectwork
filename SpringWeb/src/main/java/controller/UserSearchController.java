package controller;

import java.util.List;

import logic.UserLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pbean.UserInfo;

@Controller
public class UserSearchController {
	@Autowired
	private UserLogic userLogic;

	@RequestMapping(value="/userSearch.json", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<UserInfo>
		searchUser(@RequestParam(required=false) String name){	
		//int i = 100/0;(main.jsp에서 오류 일부러 발생 위해 코딩
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}*/ //timeout 오류 고의 발생위해 코딩
		List<UserInfo> list = userLogic.searchByName(name);
		return list;
	}
	//아이디 중복 체크
	@RequestMapping(value="/userSearchId.json", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<UserInfo>
		searchUserId(@RequestParam(required=false) String userid){
		List<UserInfo> list = userLogic.searchByIdAjax(userid);
		return list;
	}
}
