package faq.dto;

public class FAQ {
	
	private int faqIdx;
	private String faqQuestion;
	private String faqAnswer;
	
	public FAQ() {}

	public FAQ(int faqIdx, String faqQuestion, String faqAnswer) {
		super();
		this.faqIdx = faqIdx;
		this.faqQuestion = faqQuestion;
		this.faqAnswer = faqAnswer;
	}

	@Override
	public String toString() {
		return "FaQ [faqIdx=" + faqIdx + ", faqQuestion=" + faqQuestion + ", faqAnswer=" + faqAnswer + "]";
	}

	/**
	 * @return the faqIdx
	 */
	public int getFaqIdx() {
		return faqIdx;
	}

	/**
	 * @param faqIdx the faqIdx to set
	 */
	public void setFaqIdx(int faqIdx) {
		this.faqIdx = faqIdx;
	}

	/**
	 * @return the faqQuestion
	 */
	public String getFaqQuestion() {
		return faqQuestion;
	}

	/**
	 * @param faqQuestion the faqQuestion to set
	 */
	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}

	/**
	 * @return the faqAnswer
	 */
	public String getFaqAnswer() {
		return faqAnswer;
	}

	/**
	 * @param faqAnswer the faqAnswer to set
	 */
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
	
	
	
	
	

}
