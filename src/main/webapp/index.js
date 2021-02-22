ymaps.ready(init);
let map;
let placemarks=
    {
        "fromlng":0,
        "fromlat":0,
        "tolng":0,
        "tolat":0,

    }
    function elog(ev, object) {
    placemarks[object.id] =  object.value;
    console.log(placemarks);
    initPlacemark(placemarks)
        initPlacemark2(placemarks)
}
function init(){
  map=new ymaps.Map('map',{
    center:[53.893009, 27.567444],
    zoom:12,
    control:['zoomControl'],
    behaviors:['drag']

});

}
function initPlacemark(loc) {
    for (let i = 0; i <= 1; i++) {
        let placemark = new ymaps.Placemark([loc["fromlng"], loc["fromlat"]], {
                hintContent: 'lol',
                balloonContent: 'lollll'
            },
            {
                iconLayouts: 'default#image',
                iconImageHref: 'img/user.png',
                iconImageSize: [46, 37],
                iconImageOffset: [-23, -57]

            });
        map.geoObjects.add(placemark)
    }
}
function initPlacemark2(loc) {
    for (let i = 0; i <= 1; i++) {
        let placemark2 = new ymaps.Placemark([loc["tolng"], loc["tolat"]], {
                hintContent: 'lol',
                balloonContent: 'lollll'
            },
            {
                iconLayouts: 'default#image',
                iconImageHref: 'img/user.png',
                iconImageSize: [46, 37],
                iconImageOffset: [-23, -57]

            });
        map.geoObjects.add(placemark2)
    }
}

    


