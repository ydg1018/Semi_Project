package util;

public class Paging {

private int curPage; //현재 페이지 번호
private int totalCount; //총 게시글 수
private int listCount; //한 페이지에 보여질 게시글의 수
private int totalPage; //총 페이지 수

private int pageCount; //한 화면에 출력될 페이지번호의 개수
private int startPage; //화면에 보이는 시작 페이지 번호
private int endPage; // 화면에 보이는 끝 페이지 번호
private int startNo; // 화면에 보이는 게시글의 시작 번호
private int endNo; // 화면에 보이는 게시글의 끝 번호

    
public Paging() {}

public Paging(int totalCount, int curPage) {
	setTotalCount(totalCount);
	setCurPage(curPage);
	
	makePaging();
}

public Paging(int totalCount, int curPage, int listCount, int pageCount) {
	setTotalCount(totalCount);
	setCurPage(curPage);
	
	setListCount(listCount);	//화면에 보여질 게시글 개수 지정하기
	setPageCount(pageCount);	//화면에 보여질 페이지 개수 지정하기
	
	makePaging();
	
}

//페이징 정보를 계산(생성)하는 메소드
private void makePaging() {
	
	if(totalCount == 0)		return; //게시글이 없는 경우 중단
	
	if(curPage == 0)		setCurPage(1); //첫 페이지를 기본 페이지로 설정한다
	if(listCount == 0)		setListCount(10); //화면에 보여질 게시글 수를 10개로 기본 설정한다
	if(pageCount == 0)		setPageCount(10); //화면에 보여질 페이지 수를 10개로 기본 설정한다
	
	//-----------------------------------------------
	
	//총 페이지 수 계산
	totalPage = totalCount / listCount; // 총 게시글 수 / 한 페이지 게시글 수
	
	//총 페이지 수 보정
	//	-> 마지막 페이지에 보여질 게시글 수가 listrCount보다 작을 때 보여질 1페이지 추가하기
	if( totalCount % listCount > 0 ) totalPage++;
	
	//총 페이지 수 보정
	//	-> 요청 페이지가 마지막 페이지 번호보다 클 때 마지막 페이지 번호로 고정하기
	if( curPage > totalPage )	curPage = totalPage;
	
	//-----------------------------------------------
	
	//화면에 보이는 페이지 시작 번호, 끝 번호 계산
	startPage = ( (curPage-1)/pageCount ) * pageCount + 1;
	endPage = startPage + pageCount - 1;
	
	//끝 페이지 번호 보정
	if( endPage > totalPage )	endPage = totalPage;
	
	//-----------------------------------------------
	
	//화면에 보이는 게시글 시작 번호, 끝 번호 계산
	startNo = (curPage - 1 ) * listCount + 1;
	endNo = curPage * listCount;
}



@Override
public String toString() {
	return "Paging [curPage=" + curPage + ", totalCount=" + totalCount + ", listCount=" + listCount + ", totalPage="
			+ totalPage + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage=" + endPage
			+ ", startNo=" + startNo + ", endNo=" + endNo + "]";
}

public int getCurPage() {
	return curPage;
}

public void setCurPage(int curPage) {
	this.curPage = curPage;
}

public int getTotalCount() {
	return totalCount;
}

public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}

public int getListCount() {
	return listCount;
}

public void setListCount(int listCount) {
	this.listCount = listCount;
}

public int getTotalPage() {
	return totalPage;
}

public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}

public int getPageCount() {
	return pageCount;
}

public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}

public int getStartPage() {
	return startPage;
}

public void setStartPage(int startPage) {
	this.startPage = startPage;
}

public int getEndPage() {
	return endPage;
}

public void setEndPage(int endPage) {
	this.endPage = endPage;
}

public int getStartNo() {
	return startNo;
}

public void setStartNo(int startNo) {
	this.startNo = startNo;
}

public int getEndNo() {
	return endNo;
}

public void setEndNo(int endNo) {
	this.endNo = endNo;
}


}
