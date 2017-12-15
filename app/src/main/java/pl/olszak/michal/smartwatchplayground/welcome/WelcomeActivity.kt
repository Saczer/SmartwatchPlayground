package pl.olszak.michal.smartwatchplayground.welcome

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_welcome.*
import pl.olszak.michal.smartwatchplayground.R
import pl.olszak.michal.smartwatchplayground.service.PlaygroundLocationService
import pl.olszak.michal.smartwatchplayground.util.PermissionsUtil
import pl.olszak.michal.smartwatchplayground.welcome.presentation.WelcomeViewModel
import javax.inject.Inject

class WelcomeActivity : WearableActivity(){

    @Inject lateinit var viewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        viewModel.display = welcome_view
        viewModel.loadGreeting()
        viewModel.startLocationUpdates()

        if(PermissionsUtil.isLocationPermissionGranted(this)){
            startLocationService()
        }else{
            PermissionsUtil.requestLocationPermission(this)
        }

        setAmbientEnabled()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(PermissionsUtil.locationPermissionResult(requestCode, permissions, grantResults)){
            startLocationService()
        }
    }

    private fun startLocationService(){
        val serviceIntent = PlaygroundLocationService.getLocationServiceIntent(this)
        startService(serviceIntent)
    }

}
