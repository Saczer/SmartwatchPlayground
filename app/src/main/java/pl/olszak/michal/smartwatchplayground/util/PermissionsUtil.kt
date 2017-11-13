package pl.olszak.michal.smartwatchplayground.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

/**
 * @author molszak
 *         created on 13.11.2017.
 */
object PermissionsUtil {

    val LOCATION_REQUEST_CODE = 2089

    private val LOCATION_PERMISSION = Manifest.permission.ACCESS_COARSE_LOCATION

    fun checkLocationPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(context, LOCATION_PERMISSION) ==
                PackageManager.PERMISSION_GRANTED
    }

    fun requestLocationPermission(activity: Activity) {
        ActivityCompat.requestPermissions(
                activity,
                arrayOf(LOCATION_PERMISSION),
                LOCATION_REQUEST_CODE)
    }


}