package thoughtworks.socialserver;

import static java.lang.String.format;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SocialServerActivity extends Activity {
    SensorManager sensorManager;
    private TiltListener tiltListener;
    
    private TextView sensorView;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
              LocationListener mlocListener = new MyLocationListener(this);
              mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
        
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                  
        tiltListener = new TiltListener(this);
                    
        LinearLayout baseLayout = (LinearLayout) findViewById(R.id.container);
    	sensorView = new TextView(this);
		baseLayout.addView(sensorView);
    }
    
    @Override
    protected void onResume() {
    
    	super.onResume();
        sensorManager.registerListener(tiltListener, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_NORMAL);
    }
    
    @Override
    protected void onStop() {
       	super.onStop();
       	sensorManager.unregisterListener(tiltListener );
    }

    private void broadcastLocationAndTilt() {
    }

    public void callWebService(String latitude, String longitude) {
        String result = null;
        HttpClient httpclient = new DefaultHttpClient();
        String getUrl = format("http://10.16.3.70:3000/?latitude=%s&longitude=%s", latitude, longitude);
        HttpGet request = new HttpGet(getUrl);
        request.addHeader("deviceId", "someDeviceId");
        ResponseHandler<String> handler = new BasicResponseHandler();
        try {
            result = httpclient.execute(request, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        httpclient.getConnectionManager().shutdown();
        Log.i("GET Request: ", result);
    }

	public void updateSensor(int sensorType, float values[]) {
		sensorView.setText("Values : " + values[0] +  " : " + values[1] + " : "+ values[2]);
	}
}