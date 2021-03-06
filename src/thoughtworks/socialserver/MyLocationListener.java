package thoughtworks.socialserver;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class MyLocationListener implements LocationListener {

	private final Context context;

	public MyLocationListener(Context context) {
		this.context = context;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Double latitude = location.getLatitude();
		Double longitude = location.getLongitude();
		Toast.makeText(context, latitude+":"+longitude, 5000);
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
