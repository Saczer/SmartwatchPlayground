package pl.olszak.michal.smartwatchplayground.main

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import dagger.android.AndroidInjection
import pl.olszak.michal.smartwatchplayground.R

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        // Enables Always-on
        setAmbientEnabled()
    }
}
