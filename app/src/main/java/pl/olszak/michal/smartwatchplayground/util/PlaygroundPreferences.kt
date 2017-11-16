package pl.olszak.michal.smartwatchplayground.util

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.util.extension.Doubles
import javax.inject.Inject

/**
 * @author molszak
 *         created on 13.11.2017.
 */
class PlaygroundPreferences @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun setLocationDetails(latitude : Double, longitude : Double) {
        val editor = sharedPreferences.edit()

        editor.putLong(LATITUDE_KEY, java.lang.Double.doubleToRawLongBits(latitude))
        editor.putLong(LONGITUDE_KEY, java.lang.Double.doubleToRawLongBits(longitude))

        editor.apply()
    }

    fun getLocation(): Location {
        val latitude = sharedPreferences.getLong(
                LATITUDE_KEY,
                Doubles.toRawLongBits(0.0))
        val longitude = sharedPreferences.getLong(
                LONGITUDE_KEY,
                Doubles.toRawLongBits(0.0))

        return Location(Doubles.fromRawLongBits(latitude) ,Doubles.fromRawLongBits(longitude))
    }

    fun registerOnSharedPreferencesChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
    }

    fun uregisterOnSharedPreferencesChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener){
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
    }


    companion object {
        val LATITUDE_KEY = "preferences-latitude-key"
        val LONGITUDE_KEY = "preferences-longitude-key"

        fun hasGPS(context: Context): Boolean =
                context.packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS)

    }


}