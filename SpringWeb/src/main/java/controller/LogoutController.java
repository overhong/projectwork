package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// 난 컨트롤러다. 하고 스프링한테 알려쥼
public class LogoutController {

	@RequestMapping("/index.html")
	// index.html이라는 주문이 들어오면 일루오셈 웬만하면 jsp로 주지마세요..
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		// 현재시간
		String timestamp = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초")
				.format(Calendar.getInstance().getTime());

		// View 만들기(정의)
		modelAndView.setViewName("index"); // 뷰 이름을 index로 하셈
		// 경로는 web-inf/view/index.***
		
		//Model 설정
		modelAndView.addObject("now", timestamp); //(모델명,실제객체);
		System.out.println("LogoutController 실행완료");
		return modelAndView;
	}
}
