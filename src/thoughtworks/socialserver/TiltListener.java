package thoughtworks.socialserver;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class TiltListener implements SensorEventListener{

    float[] values;

    public void onSensorChanged(SensorEvent sensorEvent) {
        if(Sensor.TYPE_ACCELEROMETER == sensorEvent.sensor.getType()){
            values = sensorEvent.values.clone();
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
