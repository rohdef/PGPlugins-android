function runPlugin() {
  cordova.exec(
    null,               // Success callback
    null,               // Error callback
    "PGPlugins",        // Plugin name
                        // named in res/xml/config.xml
    "mySimplePlugin",   // Method name
    []                  // Arguments
    );
};

