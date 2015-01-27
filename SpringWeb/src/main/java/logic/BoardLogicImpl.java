package logic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pbean.Board;
import pbean.BoardFile;
import vbean.VBoard;
import dao.BoardDAO;

public class BoardLogicImpl implements BoardLogic {
	@Autowired
	private BoardDAO boardDAO;

	public List<Board> getBoardList() {
		return this.boardDAO.getBoardList();
	}

	
	public int getBoardCnt() {
		return this.boardDAO.getBoardCnt();
		
	}
	
	public List<Board> getBoardList(Map<String, Object> map) {
		return this.boardDAO.getBoardList(map);
	}

	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	public Board getBoard(int num) {
		return this.boardDAO.getBoard(num);
	}

	// 게시물추가
	public void addArticle(VBoard vboard) {
		Board board = new Board(vboard);
		// 값주기. 일일히 안해주고 위와같이 줄 수 있는 이유는
		// Board에서 맵핑시켜줬기때문에..(VBoard와연결.)

		// board.setNum(vboard.getNum());
		// board.setUserid(vboard.getUserid());
		// board.setTitle(vboard.getTitle());
		// board.setContent(vboard.getTitle());
		// board.setFilename(vboard.getFilename());
		// board.setRef(vboard.getRef());
		// board.setRe_level(vboard.getRe_level());
		// board.setRe_step(vboard.getRe_step());
		// board.setRegdate(vboard.getRegdate());

		this.boardDAO.addArticle(board);

	}

	public void updArticle(VBoard vboard) {
		Board board = new Board(vboard);
		this.boardDAO.updArticle(board);
	}

	public void delArticle(int num) {
		this.boardDAO.delArticle(num);
	}

	public void addArticleCount(int num) {
		this.boardDAO.addArticleCount(num);

	}

	public List<BoardFile> getBoardFile(int boardnum) {
		// TODO Auto-generated method stub
		return null;
	}





}
