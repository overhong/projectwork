package dao;

import java.util.List;
import java.util.Map;

import pbean.Board;
import pbean.BoardFile;

public interface BoardDAO {
	public List<Board> getBoardList();//전체 게시물 조회
	
	public List<Board> getBoardList(Map<String, Object> map);//부분 게시물 조회
	
	public Board getBoard(int num); //게시물 1건 조회
	
	public int getBoardCnt();//게시물 갯수 취득
	
	public void addArticle(Board board);//게시물 추가
	
	public void updArticle(Board board);//게시물 수정
	
	public void delArticle(int num);//게시물 삭제
	
	public void addArticleCount(int num);//조회수 증가
	
	public void addVideo(BoardFile video);//동영상 파일 추가
	
	public List<BoardFile> getBoardFile(int boardnum);
	
	
	
}
