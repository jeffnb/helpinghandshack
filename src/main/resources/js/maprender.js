  var currentLocation = {
      lat: 36.165754,
      lng: -115.147878
  }; // default of Las Vegas center 36.165754, -115.147878

  var charities = [];
  var charity = {
      name: 'charity 1',
      siteURL: 'http://google.com',
      locate: {
          lat: 36.165,
          lng: -115.145
      },
      hoursOfOperation: '10am to 5pm',
      phone: '702-555-1212',
      email: 'a@char1.com',
      service: 'food'
  }
  charities.push(charity);

  charity = {
      name: 'charity 2',
      siteURL: 'http://yahoo.com',
      locate: {
          lat: 36.16,
          lng: -115.14
      },
      hoursOfOperation: '11am to 5pm',
      phone: '702-555-1213',
      email: 'a@char2.com',
      service: 'food'
  }
  charities.push(charity);

  var charity = {
      name: 'health 1',
      siteURL: 'http://google.com',
      locate: {
          lat: 36.175,
          lng: -115.145
      },
      hoursOfOperation: '10am to 5pm',
      phone: '702-555-1212',
      email: 'health@char1.com',
      service: 'health'
  }
  charities.push(charity);
  var charity = {
      name: 'charity health 2',
      siteURL: 'http://google.com',
      locate: {
          lat: 36.165,
          lng: -115.145
      },
      hoursOfOperation: '10am to 5pm',
      phone: '702-555-1212',
      email: 'ahalthchar1.com',
      service: 'health'
  }
  charities.push(charity);
  var charity = {
      name: 'charity health 3',
      siteURL: 'http://google.com',
      locate: {
          lat: 36.165,
          lng: -115.185
      },
      hoursOfOperation: '10am to 5pm',
      phone: '702-555-1212',
      email: 'a@char1.com',
      service: 'health'
  }
  charities.push(charity);

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

  function resetMap() {
      google.maps.event.trigger(map, 'resize');
      initialize();
  }

  var i;
  var radius = 1; //  default radius to 1 mile
  var mapCenter;

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
          if (serviceSelected.toLowerCase() !== charities[i].service.toLowerCase()) {
              continue;
          }

          var marker = new google.maps.Marker({
              position: new google.maps.LatLng(charities[i].locate.lat, charities[i].locate.lng),
              map: map,
              icon: {
                  path: google.maps.SymbolPath.CIRCLE,
                  scale: 10
              },
              animation: google.maps.Animation.DROP,
              title: charities[i].name + ' ' + charities[i].email
          });

          google.maps.event.addListener(marker, 'click', (function (marker, i) {
              return function () {
                  var contentStr = charities[i].name + '<br/>' + charities[i].hoursOfOperation + '<br/>' + charities[i].email + '<br/>' + charities[i].phone + '<br/><a href="' + charities[i].siteURL + '">' + charities[i].siteURL + '</a>';

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

  google.maps.event.addDomListener(window, 'load', initialize);