<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.dto.HouseInfoDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${request.getContextPath()}"/>
 
<section class="container-fluid mb-3">
	<div class="text-center">
		<div class="dropdown bg-dark">
			<div class="btn-group">
				<form method="post" action="/search/dong">
					<div class="btn-group">
						<div class="text-white mr-2">도시 <select id="sido" class="btn btn-light p-0">
							<option value="0" class="text-dark">선택</option>
						</select></div>
						<div class="text-white mr-2">구 <select id="gugun" class="btn btn-light p-0">
							<option value="0" class="text-dark">선택</option>
						</select></div>
						<div class="text-white mr-2">동 <select id="dong" name="dong" class="btn btn-light p-0">
							<option value="0" class="text-dark">선택</option>
						</select></div>
					</div>
					<button type="submit" class="btn btn-outline-light ml-2 mr-2 pt-0 pb-0">Search</button>
					<button type="button" id="insert_interest_btn" class="btn btn-outline-light ml-2 mr-5 pt-0 pb-0">관심지역등록</button>
				</form>
				
				<form method="post" action="/search/interest">
					<div class="btn-group">
						<div class="text-white mr-2">관심지역 <select id="interest" name="interest" class="btn btn-light p-0">
							<option value="0" class="text-dark">선택</option>
						</select></div>
					</div>
					<button type="submit" class="btn btn-outline-light ml-2 mr-2 pt-0 pb-0">Search</button>
					<button type="button" id="delete_interest_btn" class="btn btn-outline-light ml-2 pt-0 pb-0">관심지역삭제</button>
				</form>
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function(){	
		$.get("${pageContext.request.contextPath}/map"
				,{act:"sido"}
				,function(data, status){
					$.each(data, function(index, vo) {
						$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
					});
				}
				, "json"
		);
		
		load_interest();
		
		$("#insert_interest_btn").on("click", insert_interest);
		$("#delete_interest_btn").on("click", delete_interest);
		
		function insert_interest() {
			$.get("${pageContext.request.contextPath}/map"
					,{act:"insert", dong:$("#dong option:selected").val()}
					,function(data, status){ }
					, "json"
			);
			location.reload();
		}
		
		function delete_interest() {
			$.get("${pageContext.request.contextPath}/map"
					,{act:"delete", dong:$("#interest option:selected").val()}
					,function(data, status){ }
					, "json"
			);
			location.reload();
		}
		
		function load_interest() {
			$("#interest").children('option').remove();
			$("#interest").append(`<option value="0" class="text-dark">선택</option>`);
			
			$.get("${pageContext.request.contextPath}/map"
					,{act:"interest"}
					,function(data, status){
						$.each(data, function(index, vo) {
							$("#interest").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
						});
					}
					, "json"
			);
		}
	});
	
	$(document).ready(function(){	
    	$("#sido").change(function() {
    		$.get("${pageContext.request.contextPath}/map"
					,{act:"gugun", sido:$("#sido").val()}
					,function(data, status){
						$("#gugun").empty();
						$("#gugun").append('<option value="0">선택</option>');
						$.each(data, function(index, vo) {
							$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
						});
					}
					, "json"
			);
    	});
    	
		$("#gugun").change(function() {
			$.get("${pageContext.request.contextPath}/map"
					,{act:"dong", gugun:$("#gugun").val()}
					,function(data, status){
						$("#dong").empty();
						$("#dong").append('<option value="0">선택</option>');
						$.each(data, function(index, vo) {
							$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
						});
					}
					, "json"
			);
		});
		
		$("#dong").change(function() {
			$.get("${pageContext.request.contextPath}/map"
					,{act:"apt", dong:$("#dong").val()}
					,function(data, status){
						//$("#searchResult").empty();
						//geocode(data);
					}
					, "json"
			);
		});
	});
	
/* 	function geocode(jsonData) {
		$.each(${"houseinfo"}, function(index, vo) {
			let tmpLat;
			let tmpLng;
	
			$.get("https://maps.googleapis.com/maps/api/geocode/json"
					,{	key:'AIzaSyBha4EpKagXOtp2r2jRymEMhpQSNqgizDg'
						, address:vo.dong+"+"+vo.aptName+"+"+vo.jibun
					}
					, function(data, status) {
						tmpLat = data.results[0].geometry.location.lat;
						tmpLng = data.results[0].geometry.location.lng;
						$("#lat_"+index).text(tmpLat);
						$("#lng_"+index).text(tmpLng);
						addMarker(tmpLat, tmpLng, vo.aptName);
					}
					, "json"
			);
		});
	} */
	</script>
	
	<div id="map" style="width: 100%; height: 400px; margin: auto;"></div>
	<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBha4EpKagXOtp2r2jRymEMhpQSNqgizDg&callback=initMap"></script>
	<script>
		var multi = {lat: 37.5012743, lng: 127.039585};
		var map;
		var markers = [];
		var infoWindow;
		
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				center: multi,
				zoom:17
			});
			
			infoWindow = new google.maps.InfoWindow;
			
			const myposition = "/img/my_position.png";
			
			
			//멀티캠퍼스
			// const multimarker = new google.maps.Marker({coords: multi, content: '멀티캠퍼스', iconImage: myposition});
			var marker = new google.maps.Marker({
				position:{lat:37.5012743, lan:127.039585},
				map:map
			});
			
			var multimarker = {
					coords: multi,
					iconImage: myposition,
					content: '멀티캠퍼스(역삼)'
			};
			addMarker(multimarker);
			infoWindow.setPosition(multi);
			infoWindow.setContent('멀티캠퍼스.');
			infoWindow.open(map);
			
			/*
			// Geolocation
			infoWindow = new google.maps.InfoWindow;
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					var pos = {
						lat: position.coords.latitude,
						lng: position.coords.longitude
					};
					
					var mymarker = {
							coords: pos,
							iconImage: myposition,
							content: '현재위치'
					};
					addMarker(mymarker);
					
					infoWindow.setPosition(pos);
					infoWindow.setContent('현재 나의 위치.');
					infoWindow.open(map);
					map.setCenter(pos);
				}, function() {
					handleLocationError(true, infoWindow, map.getCenter());
				});
			} else {
				handleLocationError(false, infoWindow, map.getCenter());
			}
			*/
		}
		
		
		function handleLocationError(browserHasGeolocation, infoWindow, pos) {
			infoWindow.setPosition(pos);
			infoWindow.setContent(browserHasGeolocation ?
				'Error: Geolocation 서비스 실패.' :
				'Error: Geolocation을 지원하지 않는 브라우저.');
			infoWindow.open(map);
		}
		
		function addMarker(props) {
			const marker = new google.maps.Marker({
				position: new google.maps.LatLng(parseFloat(props.coords.lat),parseFloat(props.coords.lng)),
				map: map
			});
			map.setCenter(marker.getPosition());
			map.setZoom(15);
			
			if(props.iconImage){
				marker.setIcon(props.iconImage);
			}

			if(props.content){
				infoWindow = new google.maps.InfoWindow({
					content:props.content
				});

			}
			
			marker.addListener('click', function() {
				map.setZoom(17);
				map.setCenter(marker.getPosition());
				bounceMarker(marker);
			});
			markers.push(marker);
			setMapOnAll(map);
		}
		
		function bounceMarker(marker) {
			if (marker.getAnimation() !== null) {
				marker.setAnimation(null);
			} else {
				marker.setAnimation(google.maps.Animation.BOUNCE);
			}
		}
		
		function deleteMarkers() {
			clearMarkers();
			markers = [];
		}
		
		function clearMarkers() {
			setMapOnAll(null);
		}
		
		function setMapOnAll(map) {
			for (let i = 0; i < markers.length; i++) {
				markers[i].setMap(map);
			}
		}
	</script>
</section>