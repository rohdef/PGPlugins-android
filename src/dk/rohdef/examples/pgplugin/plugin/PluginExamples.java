package dk.rohdef.examples.pgplugin.plugin;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;

public class PluginExamples extends CordovaPlugin {
	// Change this to false try the error callback
	private boolean doSuccess = true;
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		boolean returnValue = false;
		
		if (action.equals("mySimplePlugin")) {
			if (doSuccess) {
				callbackContext.success("It works :)");
				returnValue = true;
			} else {
				callbackContext.error("I vote for natural selection.");
			}
			
		}
		return returnValue;
	}
}