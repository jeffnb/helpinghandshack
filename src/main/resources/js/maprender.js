  var currentLocation = {
      lat: 36.165754,
      lng: -115.147878
  }; // default of Las Vegas center 36.165754, -115.147878

  var healthMarker = "/assets/img/health.png",
      shelterMarker = "/assets/img/shelter.jpg",
      foodMarker = "/assets/img/food.jpg",
      child_careMarker = "/assets/img/child_care.jpg";

  var charities = [];

  function convertMilesToMeters(miles) {
      return miles * 1609.34;
  }

  function getCircle(mapCenter, radiusInMiles) {
      var populationOptions = {
          strokeColor: '#FF0000',
          strokeOpacity: 0.8,
          strokeWeight: 2,
          fillColor: '#FF0000',
          fillOpacity: 0.35,
          map: map,
          center: mapCenter,
          radius: convertMilesToMeters(radiusInMiles)
      };

      var circ = new google.maps.Circle(populationOptions);

      return circ;
  }

  var map;
  $('document').ready(function () {

      getJSONCharities('food', 1);

      $("#selDistance").change(function () {
          resetMap();
      });

      $("#selService").change(function () {
          resetMap();
      });

      $("#locationLbl").text(currentLocation.lat + ' ' + currentLocation.lng);

      if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function (position) {
              currentLocation.lat = position.coords.latitude;
              currentLocation.lng = position.coords.longitude;

              $("#locationLbl").text(currentLocation.lat + ' ' + currentLocation.lng);

              resetMap();
          });
      }

  });

  $(window).resize(function () {
      resetMap();
  });

  function resetMap() {
      google.maps.event.trigger(map, 'resize');
      initialize();
  }

  var i;
  var radius = 1; //  default radius to 1 mile
  var mapCenter;

  function getMarkerIconPath(charityService) {
      var returnPath;

      switch (charityService) {
          case 'Food':
              returnPath = foodMarker;
              break;
          case 'Health':
              returnPath = healthMarker;
              break;
          case 'Shelter':
              returnPath = shelterMarker;
              break;
          case 'Child Care':
              returnPath = child_careMarker;
              break;
      }
      return returnPath;
  }

  function initialize() {
      if ($("#selDistance").val()) {
          radius = $("#selDistance").val();
      }

      mapCenter = new google.maps.LatLng(currentLocation.lat, currentLocation.lng);

      var mapOptions = {
          // zoom: 12,
          center: mapCenter
      };
      map = new google.maps.Map(document.getElementById('map-canvas'),
          mapOptions);

      var serviceSelected = $("#selService").val();

      for (i = 0; i < charities.length; i++) {

          var imgh = {
              url: getMarkerIconPath(charities[i].services[0]),
              size: new google.maps.Size(71, 71),
              origin: new google.maps.Point(0, 0),
              anchor: new google.maps.Point(17, 34),
              scaledSize: new google.maps.Size(25, 25)
          };

          var marker = new google.maps.Marker({
              position: new google.maps.LatLng(charities[i].location.y, charities[i].location.x),
              map: map,
              icon: imgh,
              animation: google.maps.Animation.DROP,
              title: charities[i].name + ' ' + charities[i].email
          });

          google.maps.event.addListener(marker, 'click', (function (marker, i) {
              return function () {
                  var contentStr = '<a href="/organizations/' + charities[i].id + '">' + charities[i].name + '</a>' +
                      '<br/>' + charities[i].hours + '<br/>' + charities[i].phone + '<br/>' + charities[i].services.join(",");

                  var infowindow = new google.maps.InfoWindow({
                      content: contentStr
                  });

                  infowindow.open(map, marker);
              }
          })(marker, i));
      } // for loop charities

      var circle = getCircle(mapCenter, radius);

      map.fitBounds(circle.getBounds());

  } // initialize()

  function getJSONCharities(charityService, radius) {
      $.getJSON("/organizations/service/" + charityService + "?lat=36.165754&long=-115.147878&dist=" + radius, function (data) {

          $.each(data, function (key, val) {
              charities.push(val);
          });

          resetMap();
      });
  }

  google.maps.event.addDomListener(window, 'load', initialize);