package pl.olszak.michal.smartwatchplayground.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.IBinder
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener
import dagger.android.AndroidInjection
import pl.olszak.michal.smartwatchplayground.util.PermissionsUtil
import pl.olszak.michal.smartwatchplayground.util.PlaygroundPreferences
import javax.inject.Inject

/**
 * @author molszak
 *         created on 13.11.2017.
 */
class PlaygroundLocationService : Service(), OnSuccessListener<Location> {

    @Inject internal lateinit var preferences : PlaygroundPreferences

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null && intent.action == CHECK_LOCATION_STATUS) {
            if (PermissionsUtil.isLocationPermissionGranted(this)) {
                val provider = LocationServices.getFusedLocationProviderClient(this)
                provider.lastLocation.addOnSuccessListener(this)
            }

            return START_STICKY
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onSuccess(location: Location?) {
        if (location != null) {
            preferences.setLocationDetails(location.longitude, location.latitude)
        }

        stopSelf()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        private val CHECK_LOCATION_STATUS = "check-location-status-action"

        fun getLocationServiceIntent(context: Context) : Intent{
            val intent = Intent(context, PlaygroundLocationService::class.java)
            return intent.apply {
                action = CHECK_LOCATION_STATUS
            }
        }
    }
}