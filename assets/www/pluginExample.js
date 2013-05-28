function runPlugin() {
  // Writes a event message to the div.
  var listener = function(message) {
    var div = $('#response'); 
    div.append('<p>Event: ' + message + '</p>');
  };
  
  cordova.exec(
    listener,            // Success callback
    null,              // Error callback
    "PGPlugins",        // Plugin name
                        // named in res/xml/config.xml
    "start",            // Method name
    []                  // Arguments
    );
};

function stopPlugin() {
  cordova.exec(
	null,            // Success callback
	null,              // Error callback
	"PGPlugins",        // Plugin name
  	                    // named in res/xml/config.xml
	"stop",             // Method name
	[]                  // Arguments
    );
}

$().ready(function() {
	$('#runPlugin').click(runPlugin);
	$('#stopPlugin').click(stopPlugin);
});