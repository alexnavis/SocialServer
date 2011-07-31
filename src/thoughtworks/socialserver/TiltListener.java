package thoughtworks.socialserver;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class TiltListener implements SensorEventListener{

    float[] values;
	private final SocialServerActivity socialServerActivity;

    public TiltListener(SocialServerActivity activity) {
		this.socialServerActivity = activity;
    	
    }
    
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(Sensor.TYPE_ORIENTATION == sensorEvent.sensor.getType()){
            values = sensorEvent.values.clone();
            this.socialServerActivity.updateSensor(sensorEvent.sensor.getType(), values);
        }
        
    }

    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
