package dk.rohdef.examples.pgplugin.plugin;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;

import android.util.Log;

public class PluginExamples extends CordovaPlugin {
	// Callback used for events
	private CallbackContext eventCallback;
	// A timer to simulate events
	private Timer timer;
	
	public PluginExamples() {
		timer = new Timer();
	}
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		boolean returnValue = false;

		if (action.equals("start")) {
			// This should in most cases include a check to see
			// if the task is already started. Examples of this 
			// can be found in the phonegap-plugins github repository.

			eventCallback = callbackContext;
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					Log.i("Timer", "timer called");
					
					PluginResult pluginResult = new PluginResult(Status.OK, "Timer says hello :)");
					// Keep the callback, so we can keep calling it.
					pluginResult.setKeepCallback(true);
					
					eventCallback.sendPluginResult(pluginResult);
				}
			}, 500, 3000);
			
			returnValue = true;
		} else if (action.equals("stop")) {
			timer.cancel();
			returnValue = true;
		}
		
		return returnValue;
	}
}