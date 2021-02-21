let map;
function initialize() {
    let mapOptions = {
        zoom: 8,
        center: new google.maps.LatLng(53.893009, 27.567444)
    };
    map = new google.maps.Map(document.getElementById('googleMap'),
        mapOptions);
}
google.maps.event.addDomListener(window, 'load', initialize);