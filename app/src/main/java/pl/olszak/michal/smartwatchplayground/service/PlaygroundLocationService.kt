package pl.olszak.michal.smartwatchplayground.service

import android.app.Service
import android.content.Intent
import android.location.Location
import android.os.IBinder
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener
import pl.olszak.michal.smartwatchplayground.util.PermissionsUtil
import pl.olszak.michal.smartwatchplayground.util.PreferencesUtil

/**
 * @author molszak
 *         created on 13.11.2017.
 */
class PlaygroundLocationService : Service(), OnSuccessListener<Location> {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null && intent.action == CHECK_LOCATION_STATUS) {
            if (PermissionsUtil.checkLocationPermission(this)) {
                val provider = LocationServices.getFusedLocationProviderClient(this)
                provider.lastLocation.addOnSuccessListener(this)
            }

            return START_STICKY
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onSuccess(location: Location?) {
        if (location != null) {
            PreferencesUtil.setLocationDetails(
                    this,
                    location.longitude,
                    location.latitude)
        }

        stopSelf()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    companion object {
        val CHECK_LOCATION_STATUS = "check-location-status-action"
    }
}