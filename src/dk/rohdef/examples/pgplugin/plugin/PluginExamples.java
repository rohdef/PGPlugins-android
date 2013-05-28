package dk.rohdef.examples.pgplugin.plugin;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

public class PluginExamples extends CordovaPlugin {
	private CallbackContext eventCallback;
	private Timer timer;
	
	public PluginExamples() {
		timer = new Timer();
	}
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		boolean returnValue = false;

		if (action.equals("start")) {
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					Log.i("Timer", "timer called");
				}
			}, 5000, 5000);
			
			returnValue = true;
		} else if (action.equals("stop")) {
			timer.cancel();
			returnValue = true;
		}
		
		return returnValue;
	}
}