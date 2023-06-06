// 지도 표시 정보
var mapContainer = document.getElementById('map'),
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3
    };

// 지도 생성
var map = new kakao.maps.Map(mapContainer, mapOption);

// 지도를 클릭한 위치에 표출할 마커
var marker = new kakao.maps.Marker({
    position: map.getCenter()
});
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
    var latlng = mouseEvent.latLng;
    marker.setPosition(latlng);

    var coordinate = latlng.getLat() + ', ' + latlng.getLng();
    var coordDiv = document.getElementById('coordinate');
    coordDiv.value = coordinate;
});