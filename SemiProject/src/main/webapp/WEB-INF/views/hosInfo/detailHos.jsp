<%@page import="java.util.List"%>
<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<button class="btn btn-info" onclick="location.href='../hos/list'">병원 전체 목록</button>
</h1>

<hr>
<br>
<p style="margin-top:-12px"></p>
<div id="map" style="width:50%; height:350px; margin: 0 auto;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8dac43c5806fc51358462c78ce0d3a41"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨 
    }; 

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
    
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function(position) {
        
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        
        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="padding:5px;">현재 위치</div>'; // 인포윈도우에 표시될 내용입니다
        
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
            
      });
    
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    
    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
        message = 'geolocation을 사용할수 없어요..'
        
    displayMarker(locPosition, message);
}

// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, message) {

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    
    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        content : iwContent,
        removable : iwRemoveable
    });
    
    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}    
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

</body>