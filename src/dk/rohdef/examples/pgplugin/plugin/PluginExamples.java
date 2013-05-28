package dk.rohdef.examples.pgplugin.plugin;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class PluginExamples extends CordovaPlugin {
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		boolean returnValue = false;
		try {
			String argument = args.getString(0);
			
			if (action.equals("mySimplePlugin")) {
				if (argument.equals("ok")) {
					callbackContext.success("It works :)");
					returnValue = true;
				} else {
					callbackContext.error("I vote for natural selection.");
				}
			}
		} catch (JSONException e) {
			callbackContext.error("No arguments sent :(");
		}
		
		return returnValue;
	}
}