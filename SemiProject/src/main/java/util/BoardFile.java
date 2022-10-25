package util;

import java.util.Date;

public class BoardFile {
	private int fileno;
	private int boardno;
	private String originname;
	private String storedname;
	private int filesize;
	private Date insertdat;
	private int cateno;
	
	public BoardFile() {}

	public BoardFile(int fileno, int boardno, String originname, String storedname, int filesize, Date insertdat, int cateno) {
		super();
		this.fileno = fileno;
		this.boardno = boardno;
		this.originname = originname;
		this.storedname = storedname;
		this.filesize = filesize;
		this.insertdat = insertdat;
		this.cateno = cateno;
	}

	@Override
	public String toString() {
		return "BoardFile [fileno=" + fileno + ", boardno=" + boardno + ", originname=" + originname + ", storedname="
				+ storedname + ", filesize=" + filesize + ", insertdat=" + insertdat + ", cateno=" + cateno + "]";
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getOriginname() {
		return originname;
	}

	public void setOriginname(String originname) {
		this.originname = originname;
	}

	public String getStoredname() {
		return storedname;
	}

	public void setStoredname(String storedname) {
		this.storedname = storedname;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public Date getInsertdat() {
		return insertdat;
	}

	public void setInsertdat(Date insertdat) {
		this.insertdat = insertdat;
	}
	
	public int getCateno() {
		return cateno;
	}
	
	public void setCateno(int cateno) {
		this.cateno = cateno;
	}
	
}