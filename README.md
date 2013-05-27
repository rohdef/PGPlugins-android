# Example: 1 - Basic plugin

This plugin is a proof of concept. What is does is send a signal 
to a PhoneGap plugin and send a simple JavaScript alert back 
to the web code.

## Interesting files:
Most of the files are just standard files. In the _assets/www_ folder I have 
made an simple html-file containing a button that runs the 
JavaScript and an div-tag for later responses.

### res/xml/config.xml
Maps native to JavaScript, so JavaScript can reach the native code. 
The plugins-element contains a list of plugins as plugin-elements.
The attributes name and value provides a mapping that PhonGap uses 
to make Java-code available to JavaScript. The name part is the 
reference JavaScript uses (PGPlugins in this example), and the 
value identifies the Java class to execute (dk.rohdef.examples.
pgplugin.plugin.PluginExamples in this example). Thus the line 
looks as follows:

    <plugin name="PGPlugins" value="dk.rohdef.examples.pgplugin.plugin.PluginExamples" />

### src/dk/rohdef/examples/pgplugin/plugin/PluginExamples.java
Mostly normal Java code, it extends CordovaPlugin and overrides 
the execute method. The method returns true on success and false 
on failure.

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        // React to the action requested from JavaScript.
        if (action.equals("mySimplePlugin")) {
            // What to do on the action goes here. 
        }
    }

The parameters is as follows _action_ is the _action_ 
passed from JavaScript, the _JSONArray args_ is the optional 
arguments passed (in this example it's empty). _CallbackContext 
callbackContext_ is the context used for the callback functions 
in JavaScript, this will be covered in the next part.

### www/pluginExample.js
This file calls the plugin using the mapping from _PGPlugins_ to 
_dk.rohdef.examples.pgplugins.plugin.PluginExamples_ that we 
defined in_res/xml/config.xml_. And calls the action _mySimplePlugin_ 
that we react to in the java code.

## Navigation
[Next: 2 Simple callback](https://github.com/rohdef/PGPlugins-android/tree/2_Simple_callback)

[List of examples](https://github.com/rohdef/PGPlugins-android/)

