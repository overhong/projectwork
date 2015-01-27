package dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import pbean.Board;
import pbean.BoardFile;
import utils.MyBatisManager;
import dao.BoardDAO;

public class BoardDAOImpl implements BoardDAO {

   public List<Board> getBoardList() {
      List<Board> list = null;
      SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
      // sqlSession.close();
      try {
         list = sqlSession.selectList("dao.BoardDAO.getBoardList");
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }
      return list;
      // return sqlSession.selectList("dao.BoardDAO.getBoardList");
      // BoardMapper.xml의("namespace.id")
   }

   public Board getBoard(int num) {
      Board board = null;
      SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
      try {
         board = sqlSession.selectOne("dao.BoardDAO.getBoard", num);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }
      return board;
      // return sqlSession.selectOne("dao.BoardDAO.getBoard", num); //
      // (bean,매개변수)
      // selectOne(); 반드시하나가있어야함.
   }
  
   public int getBoardCnt() {
	      int cnt = 0;
	      SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
	      try {
	         cnt = sqlSession.selectOne("getBoardCnt");
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         sqlSession.close();
	      }
	      return cnt;
	   }
   public void addArticle(Board board) {
      SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
      try {
         sqlSession.insert("dao.BoardDAO.insertBoard", board);
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.commit();
         sqlSession.close();
      }
      // sqlSession.insert("dao.BoardDAO.insertBoard", board);
      // sqlSession.commit();
   }

   public void updArticle(Board board) {
      SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
      try {
         sqlSession.update("dao.BoardDAO.updateBoard", board);
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.commit();
         sqlSession.close();
      }
      // sqlSession.update("dao.BoardDAO.updateBoard", board);
      // sqlSession.commit();
   }

   public void delArticle(int num) {
      SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
      try {
         sqlSession.delete("dao.BoardDAO.deleteBoard",num);
      } catch (Exception e) {
    	  e.printStackTrace();
      } finally {
         sqlSession.commit();
         sqlSession.close();
      }
      // sqlSession.delete("dao.BoardDAO.deleteBoard", num);
      // sqlSession.commit();
   }

   public void addArticleCount(int num) {
      SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
      try {
         sqlSession.insert("dao.BoardDAO.updateCount",num);
      } catch (Exception e) {
    	  e.printStackTrace();
      } finally {
         sqlSession.commit();
         sqlSession.close();
      }
      
   }
 
   public List<Board> getBoardList(Map<String, Object> map) {
	   List<Board> list = null;
	   SqlSession sqlSession = MyBatisManager.getSqlSession().openSession();
	   try{
		   sqlSession.selectList("getBoardListPaging", map);
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   sqlSession.commit();
	       sqlSession.close();
	   }
	   return list;
	
    }

	@Override
	public void addVideo(BoardFile video) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardFile> getBoardFile(int boardnum) {
		// TODO Auto-generated method stub
		return null;
	}


}