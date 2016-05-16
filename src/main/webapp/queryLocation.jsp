<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
   <head>
      <title></title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

      <script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0"></script>

      <script type="text/javascript">
         
         var map = null;
 
         function GetMap()
         {
            // Initialize the map
            map = new Microsoft.Maps.Map(document.getElementById("mapDiv"),{credentials:"AhCbivzTNybshLcfZfo2Pcd_6EiMO2q_iEfB_Xx4aN3c4WNnY1Ro5BXpCNN5X3fL", mapTypeId:Microsoft.Maps.MapTypeId.road}); 

         }

         function ClickGeocode(credentials)
         {
            map.getCredentials(MakeGeocodeRequest);
         }

         function MakeGeocodeRequest(credentials)
         {

            var geocodeRequest = "http://dev.virtualearth.net/REST/v1/Locations?query=" + encodeURI(document.getElementById('txtQuery').value) + "&output=json&jsonp=GeocodeCallback&key=" + credentials;
            alert("查询条件: " + geocodeRequest);

            CallRestService(geocodeRequest);
         }

         function GeocodeCallback(result) 
         {
            alert("查询位置: " + result.resourceSets[0].resources[0].name);

            if (result &&
                   result.resourceSets &&
                   result.resourceSets.length > 0 &&
                   result.resourceSets[0].resources &&
                   result.resourceSets[0].resources.length > 0) 
            {
               // Set the map view using the returned bounding box
               var bbox = result.resourceSets[0].resources[0].bbox;
               var viewBoundaries = Microsoft.Maps.LocationRect.fromLocations(new Microsoft.Maps.Location(bbox[0], bbox[1]), new Microsoft.Maps.Location(bbox[2], bbox[3]));
               map.setView({ bounds: viewBoundaries});

               // Add a pushpin at the found location
               var location = new Microsoft.Maps.Location(result.resourceSets[0].resources[0].point.coordinates[0], result.resourceSets[0].resources[0].point.coordinates[1]);
               var pushpin = new Microsoft.Maps.Pushpin(location);
               map.entities.push(pushpin);
            }
         }

         function CallRestService(request) 
         {
            var script = document.createElement("script");
            script.setAttribute("type", "text/javascript");
            script.setAttribute("src", request);
            document.body.appendChild(script);
         }

      </script>
   </head>
   <body onload="GetMap();">
      <div id='mapDiv' style="position:relative; width:1000px; height:600px;"></div>
      <input id="txtQuery" type="text" value="Portland"/>
      <input type="button" value="定位" onclick="ClickGeocode()"/>       
   </body>
</html>