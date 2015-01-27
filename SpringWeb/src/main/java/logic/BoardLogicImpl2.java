package logic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BoardDAO;
import pbean.Board;
import pbean.BoardFile;
import vbean.VBoard;
import vbean.VideoFileItem;
@Service 
public class BoardLogicImpl2 implements BoardLogic{
	@Autowired
	private BoardDAO boardDAO;

	public List<Board> getBoardList() {
		System.out.println("BoardLogicImpl 의getBoardList 확인");
		return this.boardDAO.getBoardList();
	}

	public List<Board> getBoardList(Map<String, Object> map) {
		System.out.println("BoardLogicImpl 의 getBoardList(Mao<String.Object> map)");
		return this.boardDAO.getBoardList(map);
	}

	public Board getBoard(int num) {
		System.out.println("BoardLogicImpl 의 getBoard 확인" + num);
		return this.boardDAO.getBoard(num);
	}

	@Transactional
	public void addArticle(VBoard vboard) {
		// TODO Auto-generated method stub
		System.out.println("1 : " + vboard.getTitle());
		Board board = new Board(vboard);
		System.out.println("2 : " + board.getTitle());
		this.boardDAO.addArticle(board);
		for (VideoFileItem item : vboard.getVideoList()) {
			if (!item.getName().equals("") && !item.getFile().isEmpty()) {
				String filename = item.getName() + ".mp4";
				int boardnum = board.getNum();
				BoardFile video = new BoardFile();
				video.setFilename(filename);
				video.setBoardnum(boardnum);
				this.boardDAO.addVideo(video);
			}
		}
	}

	@Transactional
	public void updArticle(VBoard vboard) {
		System.out.println("BoardLogicImpl 의updArticle 확인");
		Board board = new Board(vboard);
		this.boardDAO.updArticle(board);
	}

	@Transactional
	public void delArticle(int num) {
		System.out.println("BoardLogicImpl 의delArtile 확인");
		this.boardDAO.delArticle(num);
	}

	@Transactional
	public void addArticleCount(int num) {
		System.out.println("BoardLogicImpl 의addArticleCount 확인"+ num);
		this.boardDAO.addArticleCount(num);
	}

	@Transactional
	public int getBoardCnt() {
		System.out.println("BoardLogicImpl 의getBoardCnt 확인");
		return this.boardDAO.getBoardCnt();
	}

	@Transactional
	public List<BoardFile> getBoardFile(int boardnum) {
		return this.getBoardFile(boardnum);
	}

}