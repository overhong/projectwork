package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import logic.BoardLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pbean.Board;
import vbean.VBoard;

@Controller
public class BoardUpdateController {
	@Autowired
	private BoardLogic boardLogic;

	public void setBoardLogic(BoardLogic boardLogic) {
		this.boardLogic = boardLogic;
	}

	private String formViewName = "/updateBoardForm";

	@RequestMapping(value = "/update.html", method = RequestMethod.GET)
	// get방식으로.
	public ModelAndView form(@RequestParam("num") int num) {
		Board board = this.boardLogic.getBoard(num);
	
		
		return new ModelAndView(formViewName,"board",board);//(뷰이름, 키,객체)
	}

	@RequestMapping(value = "/update.html", method = RequestMethod.POST)
	public String submit(VBoard vboard, HttpServletRequest req) 
			throws IllegalStateException, IOException {// 서브밋버튼을눌렀다
		// 파일업로드
		MultipartFile file = vboard.getFile();
		// 파일업로드했다면
		if (file.getSize() > 0) {
			// 파일이름 설정
			vboard.setFilename(file.getOriginalFilename()); // 예)이승철.jpg
			File imageFile = new File(req.getRealPath("/") + "/images",
					vboard.getFilename());
			file.transferTo(imageFile); 
		}

		this.boardLogic.updArticle(vboard);
		System.out.println("BoardUpdateController 실행");
		// return "/boardInsertSuccess"; // 글쓰기가 완료되었습니다. 라는 기능의 jsp필요.
		return "redirect:/boardList.html"; // 로 써줘야함.
		// ridirect -sendredirect와 동일
		// return "boardList.html"이라고 쓰면 boardList.html.jsp를 찾아들어가기때문에 써주면 안됨
	}
}
