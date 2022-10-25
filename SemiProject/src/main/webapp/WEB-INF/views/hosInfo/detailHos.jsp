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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8dac43c5806fc51358462c78ce0d3a41"></script>

<p style="margin-top:-12px">
    <em class="link">
        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
        </a>
    </em>
</p>
<div id="map" style="width:100%;height:350px;"></div>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울특별시 도봉구 도당로 63', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
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