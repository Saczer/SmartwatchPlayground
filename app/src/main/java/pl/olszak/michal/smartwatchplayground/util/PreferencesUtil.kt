package pl.olszak.michal.smartwatchplayground.util

import android.content.Context
import android.content.pm.PackageManager
import android.preference.PreferenceManager
import pl.olszak.michal.smartwatchplayground.R
import pl.olszak.michal.smartwatchplayground.util.extension.DoubleExtension

/**
 * @author molszak
 *         created on 13.11.2017.
 */
object PreferencesUtil {

    fun setLocationDetails(context: Context, longitude: Double, latitude: Double) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        val editor = sharedPreferences.edit()

        val latitudeKey = context.getString(R.string.pref_latitude_key)
        val longitudeKey = context.getString(R.string.pref_longitude_key)

        editor.putLong(longitudeKey, java.lang.Double.doubleToRawLongBits(longitude))
        editor.putLong(latitudeKey, java.lang.Double.doubleToRawLongBits(latitude))

        editor.apply()
    }

    fun getLatLong(context: Context): Pair<Double, Double> {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        val latitudeKey = context.getString(R.string.pref_latitude_key)
        val longitudeKey = context.getString(R.string.pref_longitude_key)

        val latitude = sharedPreferences.getLong(
                latitudeKey,
                DoubleExtension.toRawLongBits(0.0))
        val longitude = sharedPreferences.getLong(
                longitudeKey,
                DoubleExtension.toRawLongBits(0.0))

        return DoubleExtension.fromRawLongBits(latitude)
                .to(DoubleExtension.fromRawLongBits(longitude))
    }


    fun hasGPS(context: Context): Boolean {
        return context.packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS)
    }


}