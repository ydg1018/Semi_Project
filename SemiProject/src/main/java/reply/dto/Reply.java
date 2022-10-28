package reply.dto;

import java.util.Date;

public class Reply {

	private int replyNo;
	private String replyContent;
	private Date insertDat;
	private int parentNo;
	private int boardNo;
	private int ownerNo;
	private String ownerNick;
	
	
	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", insertDat=" + insertDat
				+ ", parentNo=" + parentNo + ", boardNo=" + boardNo + ", ownerNo=" + ownerNo + ", ownerNick=" + ownerNick +"]";
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getInsertDat() {
		return insertDat;
	}

	public void setInsertDat(Date insertDat) {
		this.insertDat = insertDat;
	}

	public int getParentNo() {
		return parentNo;
	}

	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getOwnerNo() {
		return ownerNo;
	}

	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}
	
	public String getOwnerNick() {
		return ownerNick;
	}
	
	public void setOwnerNick(String ownerNick) {
		this.ownerNick = ownerNick;
	}
	
	
}
