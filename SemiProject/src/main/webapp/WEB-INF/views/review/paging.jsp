<%@page import="util.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- !!!!!<%=request.getParameter("f") == null %> --%>

<%	String fStr = request.getParameter("f") != null ?"f="+request.getParameter("f") :"f=board_title"; %>
<%	String qStr = request.getParameter("q") != null ?"q="+request.getParameter("q") :"q="; %>

<%-- 모델값 전달받기 --%>
<% Paging paging = (Paging) request.getAttribute("paging"); %>    

<div class="text-center">
	<ul class="pagination">
	
		<%-- 첫 페이지로 이동 --%>
		<%	if( paging.getCurPage() != 1 ) { %>
		<li><a href="./list?<%=fStr %>&<%=qStr %>">&larr; 처음</a></li>
		<% } %>
		
		
		<%-- 이전 페이지로 이동 --%>
		<%	if( paging.getCurPage() != 1 ) { %>
		<li><a href="./list?curPage=<%=paging.getCurPage()-1 %>&f<%=fStr %>&<%=qStr %>">&lt;</a></li>
		<% } %>
		
		
		<%-- 페이지 번호 리스트 --%>
		<!-- 현재 보고있는 페이지를 활성화 -->
		<% for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
		<%		if( i == paging.getCurPage() ) { %>
		<li class="active"><a href="./list?curPage=<%=i %>&f=<%=request.getParameter("f") %>&q=<%=request.getParameter("q") %>"><%=i %></a></li>
		<%		} else { %>
		<li><a href="./list?curPage=<%=i %>&<%=fStr %>&<%=qStr %>"><%=i %></a></li>
<%-- 		<li><a href="./list?curPage=<%=i %>&f=<%=request.getParameter("f") %>&q=<%=request.getParameter("q") %>"><%=i %></a></li> --%>
		<%		} %>
		<% 	}%>
	
		<%-- 다음 페이지로 이동 --%>
		<!-- 마지막페이지일때 버튼 안보이게 하기 -->
		<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
		<li><a href="./list?curPage=<%=paging.getCurPage()+1 %>&f<%=fStr %>&<%=qStr %>">&gt;</a></li>
		<% } %>
		
		<!-- 마지막 페이지로 이동 -->
		<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
		<li><a href="./list?curPage=<%=paging.getTotalPage() %>&f<%=fStr %>&<%=qStr %> %>">&rarr; 끝</a></li>
		<% } %>
	</ul>
</div>