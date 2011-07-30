package thoughtworks.socialserver;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class SocialServerActivity extends Activity {
    SensorManager sensorManager;
    private TiltListener tiltListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        tiltListener = new TiltListener();
        setContentView(R.layout.main);
        broadcastLocationAndTilt();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(tiltListener, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_NORMAL);
        Toast.makeText(this, tiltListener.values[0] + " " + tiltListener.values[1] + " " + tiltListener.values[2], Toast.LENGTH_SHORT).show();
    }

    private void broadcastLocationAndTilt() {
    }
}