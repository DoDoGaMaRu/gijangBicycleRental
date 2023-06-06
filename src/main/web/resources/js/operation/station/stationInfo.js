var [lat, lng] = document.getElementById('coordinate').innerText.split(",");

// 지도 표시 정보
var mapContainer = document.getElementById('map'),
    mapOption = {
        center: new kakao.maps.LatLng(lat, lng),
        level: 3
    };

// 지도 생성
var stationRegist = new kakao.maps.Map(mapContainer, mapOption);

// 지도를 클릭한 위치에 표출할 마커
var marker = new kakao.maps.Marker({
    position: stationRegist.getCenter()
});
marker.setMap(stationRegist);