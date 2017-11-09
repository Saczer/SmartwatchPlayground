package pl.olszak.michal.smartwatchplayground.main

import android.arch.lifecycle.*
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import pl.olszak.michal.smartwatchplayground.R
import javax.inject.Inject

class MainActivity : WearableActivity(), LifecycleOwner {

    private val registry : LifecycleRegistry = LifecycleRegistry(this)

    @Inject lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registry.markState(Lifecycle.State.CREATED)
        viewModel.loadGreeting()

        observeGreeting()

        setAmbientEnabled()
    }

    private fun observeGreeting() {
        viewModel.greeting.observe(this, Observer<String> { greeting ->
            displayGreeting(greeting) })
    }

    private fun displayGreeting(greeting : String?){
        text.text = greeting
    }

    override fun getLifecycle(): Lifecycle {
        return registry
    }
}
