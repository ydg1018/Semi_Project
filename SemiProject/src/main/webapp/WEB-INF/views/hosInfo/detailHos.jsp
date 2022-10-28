<%@page import="java.util.List"%>
<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>
    
<% HosInfo detailHosInfo = (HosInfo) request.getAttribute("detailHosInfo"); %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>::: <%=detailHosInfo.getHos_name() %> 정보 :::</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<h1 style="text-align: center;">
<%=detailHosInfo.getHos_name() %>
<button class="btn btn-info" onclick="location.href='../reservation?hosCode=<%=detailHosInfo.getHos_code() %>'">예약하러가기</button>

<button class="btn btn-info" onclick="location.href='../hos/list'">병원 전체 목록</button>
</h1>

<hr>
<br>

<p style="margin-top:-12px">
<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8dac43c5806fc51358462c78ce0d3a41&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.5351139, 126.863757), // 지도의 중심좌표
        level: 1 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(37.5351139, 126.863757); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>


<br><br>

<table class="table table-bordered">

<tr>
	<td class="info">주소</td>
	<td><%=detailHosInfo.getHos_add() %></td>
</tr>
<tr>
	<td class="info">우편번호</td>
	<td><%=detailHosInfo.getHos_zip() %></td>
</tr>
<tr>	
	<td class="info">전화번호</td>
	<td><%=detailHosInfo.getHos_call() %></td>
</tr>
<tr>
	<td class="info">진료시간</td>
	<td><%=detailHosInfo.getHos_time() %></td>
</tr>
<tr>
	<td class="info">오시는 길</td>
	<td><%=detailHosInfo.getHos_trans() %></td>
</tr>
<tr>
	<td class="info">주차 정보</td>
	<td><%=detailHosInfo.getHos_park() %></td>
</tr>

</table>

<%@ include file="../layout/footer.jsp" %>
