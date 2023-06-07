// 지도 표시 정보
var mapContainer = document.getElementById('map'),
    mapOption = {
        center: new kakao.maps.LatLng(35.24442266838816, 129.22241888603807),
        level: 3
    };

// 지도 생성
var stationRegist = new kakao.maps.Map(mapContainer, mapOption);

// 지도를 클릭한 위치에 표출할 마커
var marker = new kakao.maps.Marker({
    position: stationRegist.getCenter()
});
marker.setMap(stationRegist);

// 지도에 클릭 이벤트를 등록합니다
kakao.maps.event.addListener(stationRegist, 'click', function(mouseEvent) {
    var latlng = mouseEvent.latLng;
    marker.setPosition(latlng);

    var coordinate = latlng.getLat() + ',' + latlng.getLng();
    var coordDiv = document.getElementById('coordinate');
    coordDiv.value = coordinate;
});