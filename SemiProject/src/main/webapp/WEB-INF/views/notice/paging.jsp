<%@page import="util.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--모델값 전달받기 --%>
<% Paging paging = (Paging)request.getAttribute("paging"); %>    
    
<div class = "text-center">
	<ul class = "pagination">
	
		<%-- 이전 페이지로 이동 --%>
		<li><a href="./list?curPage=<%=paging.getCurPage() - 1 %>">&lt;</a></li>
	
		<%-- 페이지 번호 리스트 --%>
		<% for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
		<%		if( i==paging.getCurPage()) { %>
		<li class="active"><a href="./list?curPage=<%=i %>"><%=i %></a></li>
		<%		} else{ %>
		<li><a href="./list?curpage=<%=i %>"><%=i %></a></li>
		<% 		} %>
		<%	} %>
		
		<%-- 다음 페이지로 이동 --%>
		<li><a href="./list?curPage=<%=paging.getCurPage() + 1 %>">&gt;</a></li>
		
	</ul>
</div>