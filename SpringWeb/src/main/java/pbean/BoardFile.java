package pbean;

import java.io.Serializable;

public class BoardFile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int num;
	
	private int boardnum;
	
	private String  filename;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
