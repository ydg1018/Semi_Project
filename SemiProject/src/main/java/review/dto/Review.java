package review.dto;

import java.util.Date;

public class Review {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date insertDat;
	private Date updateDat;
	private int boardHit;
	private int ownerNo;
	private int cateNo;
	
	private String ownerNick; //따로 추가
	
	public Review() {}

	public Review(int boardNo, String boardTitle, String boardContent, Date insertDat, Date updateDat, int boardHit,
			int ownerNo, int cateNo, String ownerNick) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.insertDat = insertDat;
		this.updateDat = updateDat;
		this.boardHit = boardHit;
		this.ownerNo = ownerNo;
		this.cateNo = cateNo;
		this.ownerNick = ownerNick;
	}

	@Override
	public String toString() {
		return "Review [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", insertDat=" + insertDat + ", updateDat=" + updateDat + ", boardHit=" + boardHit + ", ownerNo="
				+ ownerNo + ", cateNo=" + cateNo + ", ownerNick=" + ownerNick + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getInsertDat() {
		return insertDat;
	}

	public void setInsertDat(Date insertDat) {
		this.insertDat = insertDat;
	}

	public Date getUpdateDat() {
		return updateDat;
	}

	public void setUpdateDat(Date updateDat) {
		this.updateDat = updateDat;
	}

	public int getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}

	public int getOwnerNo() {
		return ownerNo;
	}

	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getOwnerNick() {
		return ownerNick;
	}

	public void setOwnerNick(String ownerNick) {
		this.ownerNick = ownerNick;
	}

}
