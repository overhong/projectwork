package pbean;

import java.io.Serializable;
import java.util.Date;

import vbean.VBoard;

public class Board implements Serializable{

	private int num;
	private String userid;
	private String title;
	private String content;
	private int count;
	private Date regdate;
	private String filename;
	private int ref;
	private int re_step;
	private int re_level;
	
	public Board() {
	} // 기본생성자

	public Board(VBoard vboard) {
		// 맵핑
		this.num = vboard.getNum();
		this.userid = vboard.getUserid();
		this.title = vboard.getTitle();
		this.content = vboard.getContent();
		this.count = vboard.getCount();
		this.regdate = vboard.getRegdate();
		this.filename = vboard.getFilename();
		this.ref = vboard.getRef();
		this.re_step = vboard.getRe_step();
		this.re_level = vboard.getRe_level();
	}
	//getter, setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	
	
	
}
