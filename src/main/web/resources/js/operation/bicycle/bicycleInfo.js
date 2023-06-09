// bicycleInfo.js
var mapContainer = document.getElementById('map');
var lat = mapContainer.dataset.lat;
var lng = mapContainer.dataset.lng;

// Initialize map
var mapOptions = {
    center: new kakao.maps.LatLng(lat, lng),
    level: 3
};
var stationMap = new kakao.maps.Map(mapContainer, mapOptions);

// Set marker at the center of the map
var marker = new kakao.maps.Marker({
    position: stationMap.getCenter()
});
marker.setMap(stationMap);
