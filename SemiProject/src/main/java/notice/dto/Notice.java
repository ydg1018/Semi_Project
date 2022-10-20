package notice.dto;

import java.util.Date;

public class Notice {
	
	private int noticeIdx;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeDate;
	private int noticeHit;
	
	public Notice() {}

	public Notice(int noticeIdx, String noticeTitle, String noticeContent, Date noticeDate, int noticeHit) {
		super();
		this.noticeIdx = noticeIdx;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeHit = noticeHit;
	}

	@Override
	public String toString() {
		return "Notice [noticeIdx=" + noticeIdx + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeDate=" + noticeDate + ", noticeHit=" + noticeHit + "]";
	}

	/**
	 * @return the noticeIdx
	 */
	public int getNoticeIdx() {
		return noticeIdx;
	}

	/**
	 * @param noticeIdx the noticeIdx to set
	 */
	public void setNoticeIdx(int noticeIdx) {
		this.noticeIdx = noticeIdx;
	}

	/**
	 * @return the noticeTitle
	 */
	public String getNoticeTitle() {
		return noticeTitle;
	}

	/**
	 * @param noticeTitle the noticeTitle to set
	 */
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	/**
	 * @return the noticeContent
	 */
	public String getNoticeContent() {
		return noticeContent;
	}

	/**
	 * @param noticeContent the noticeContent to set
	 */
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	/**
	 * @return the noticeDate
	 */
	public Date getNoticeDate() {
		return noticeDate;
	}

	/**
	 * @param noticeDate the noticeDate to set
	 */
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	/**
	 * @return the noticeHit
	 */
	public int getNoticeHit() {
		return noticeHit;
	}

	/**
	 * @param noticeHit the noticeHit to set
	 */
	public void setNoticeHit(int noticeHit) {
		this.noticeHit = noticeHit;
	}

}
