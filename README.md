# Example: 4 - Events

Sends an event to JavaScript using normal JavaScript handlers.

Note! This is quite altered since the original example, to use callbacks 
rather than document and window event. This seems to me to be a better 
way of doing it. To my knowledge the original idea should still work. 
This also effectively merges example 4 and 5 from the original.

## Interesting files:

### src/dk/rohdef/examples/pgplugin/plugin/PluginExamples.java
Most of the file is quite trivial. It saves the _callbackContext_, so 
the events can be fired, and uses a timer to simulate events.

The only real change is that in stead of running _CallbackContext.success()_ or
_CallbackContext.error()_ I in stead create an instance of _PluginResult_ 
and use this for the callback:

    PluginResult pluginResult = new PluginResult(Status.OK);
    pluginResult.setKeepCallback(true);
    eventCallback.sendPluginResult(pluginResult);

This enables me to keep the callback and use it multiple times, as 
would be expected of an event listener.

Note! This example have a few flaws compared to a real use situation 
first off I should probably prevent multiple timers and it might be 
a good idea to store all the _CallbackContext_ s, that start is fired 
with, so it could support multiple listeners, finally it should clean 
up the callback(s?) on stop, by calling them with one last success.

### asserts/www/pluginExample.js
Just standard JavaScript using jQuery to add the event responses to 
the response div.

## Navigation
Note! Example 5 has been merged to example 4 in the Android examples, 
due to it being trivial compared to the original example. Using this 
structure the need for "Advanced callbacks" as I used in example 6 is 
probably also obsolete. If you need it ported please contact me, and 
I'll gladly help you port it :)

[Next: Appendix A - Plugin structure](https://github.com/rohdef/PGPlugins/tree/Appendix_A_Plugin_structure)

[List of examples](https://github.com/rohdef/PGPlugins-android/)

[Previous: 3 Arguments](https://github.com/rohdef/PGPlugins-android/tree/3_Arguments)
