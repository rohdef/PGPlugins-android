package dk.rohdef.examples.pgplugin.plugin;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;

import android.util.Log;

public class PluginExamples extends CordovaPlugin {
	private final String TAG = "PluginExamples";
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		Log.i(TAG, "Hello there");
		if (action.equals("mySimplePlugin")) {
			this.webView.sendJavascript("alert('This is executed from Java :)');");
			
			return true;
		}
		return false;
	}
}
