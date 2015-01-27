package controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// 난 컨트롤러다. 하고 스프링한테 알려쥼
public class IndexController {

	@RequestMapping("/logout.html")	
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		session.invalidate();
		
		modelAndView.setViewName("redirect:/login.html");
		return modelAndView;
	}
}
