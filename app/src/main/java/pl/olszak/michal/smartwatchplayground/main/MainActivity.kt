package pl.olszak.michal.smartwatchplayground.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.widget.Toast
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import pl.olszak.michal.smartwatchplayground.R
import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.model.viewmodel.Response
import pl.olszak.michal.smartwatchplayground.model.viewmodel.Status
import pl.olszak.michal.smartwatchplayground.service.PlaygroundLocationService
import pl.olszak.michal.smartwatchplayground.util.PermissionsUtil
import pl.olszak.michal.smartwatchplayground.util.WearableLiveDataActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : WearableLiveDataActivity() {

    @Inject lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.loadGreeting()
        viewModel.startLocationUpdates()

        observeGreeting()
        observeLocation()

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

    private fun observeLocation(){
        viewModel.location.observe(this, Observer { location ->
            if(location != null){
                displayLocation(location)
            }
        })
    }

    private fun observeGreeting() {
        viewModel.greeting.observe(this, Observer<Response<String>> { greeting ->
           if (greeting?.status == Status.SUCCESS){
               displayGreeting(greeting.data)
           }else if (greeting?.status == Status.ERROR){
               displayError(greeting.throwable)
           }
        })
    }

    private fun displayLocation(location: Location){

    }

    private fun displayGreeting(greeting: String?) {
        text.text = greeting
    }

    private fun displayError(throwable: Throwable?){
        Toast.makeText(this, "Could not display greeting", Toast.LENGTH_LONG).show()
        Timber.e(throwable)
    }

}
