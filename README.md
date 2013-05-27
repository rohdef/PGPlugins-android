# Example: 2 - Simple callback

This shows how to do a basic callback in PhoneGap.

## Interesting files:

### src/dk/rohdef/examples/pgplugin/plugin/PluginExamples.java
Does a callback calll based on the value of `doSuccess` and 
calls the success method or the error method of the `CallbackContext`. 
The `CallbackContext` simply calls the provided callback functions 
given in the JavaScript call.

The methods for the callbacks takes a `String` at the simplest. The 
`error` method also accepts `int` and `JSONOBject`, whereas `succes` 
supports a few more.

Use the `doSuccess` boolean to try the success and error 
callbacks.

### assets/www/pluginExample.js
It creates two functions and send them to the 
`cordova.exec` call, so they can be used from the native code.

## Navigation
[Next: 3 Arguments](https://github.com/rohdef/PGPlugins-android/tree/3_Arguments)

[List of examples](https://github.com/rohdef/PGPlugins-android/)

[Previous: 1 Basic plugin](https://github.com/rohdef/PGPlugins-android/tree/1_Basic_plugin)