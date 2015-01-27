package dao.mybatis;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import dao.BoardDAO;
import pbean.Board;
import pbean.BoardFile;

@Repository
public class BoardDAOImpl2 extends SqlSessionDaoSupport 
	implements BoardDAO {

	@Override
	public List<Board> getBoardList() {		
		return getSqlSession().selectList("getBoardList");
	}

	@Override
	public List<Board> getBoardList(Map<String, Object> map) {
		return getSqlSession().selectList("getBoardPaging",map);
	}

	@Override
	public Board getBoard(int num) {
		System.out.println("BoardDAOImpl2의 getBoard 확인"+ num);
		return getSqlSession().selectOne("getBoard",num);
	}

	@Override
	public int getBoardCnt() {
		System.out.println("BoardDAOImpl2의 getBoardCnt 확인");
		return getSqlSession().selectOne("getBoardCount");
	}

	@Override
	public void addArticle(Board board) {
		System.out.println("BoardDAOImpl2의 addArticle 확인 : "+board.getTitle());
		getSqlSession().insert("insertBoard", board);
		
	}

	@Override
	public void updArticle(Board board) {
		getSqlSession().update("updateBoard");
		
	}

	@Override
	public void delArticle(int num) {
		getSqlSession().delete("deleteBoard");
		
	}

	@Override
	public void addArticleCount(int num) {
		getSqlSession().insert("updateCount");
		
	}

	@Override
	public void addVideo(BoardFile video) {
		System.out.println("BoardDAOImpl2의 addVideo 확인 : " + video.getFilename());
		getSqlSession().insert("insertBoardFile",video);
		
	}

	@Override
	public List<BoardFile> getBoardFile(int boardnum) {
		System.out.println("BoardDAOImpl2의 getBoardFile 확인 : "+ boardnum);
		return getSqlSession().selectOne("getBoardFile");
	}
	
}
