ymaps.ready(init);
let placemarks=[
    {
        latitude:59.67,
        longitude:27.567444,
        hintContent:'From location',
        balloonContent:'Just balloon'

    },
    {
        latitude:53.9299587,
        longitude:27.5876762,
        hintContent:'From location',
        balloonContent:'Just balloon'

    }
];

function init(){
let map=new ymaps.Map('map',{
    center:[53.893009, 27.567444],
    zoom:12,
    control:['zoomControl'],
    behaviors:['drag']
});
placemarks.forEach(function (obj){
    let placemark=new ymaps.Placemark([obj.latitude,obj.longitude],{
        hintContent:'Shit guys office',
        balloonContent:'Just balloon'
    });
    map.geoObjects.add(placemark)
});


}
    


