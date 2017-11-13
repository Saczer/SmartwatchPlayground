package pl.olszak.michal.smartwatchplayground.util

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.os.Bundle
import android.support.wearable.activity.WearableActivity

/**
 * @author molszak
 *         created on 09.11.2017.
 */

/**W tym kontekście lifecycle nic nie daje, livedata i tak jest injectowany w activity na onCreate
oryginalnie jest zrobione za pomocą fragmentu trzymającego referencję do lifecyclestore
lifecycle store znowu przechowuje wszystkie obiekty ViewModel w mapie, ciekawe czy jest to w ogóle
czyszczone z pamięci.
Wearable nie ma wsparcia dla Lifecycle ? */
abstract class WearableLiveDataActivity : WearableActivity(), LifecycleOwner {

    private val registry: LifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registry.markState(Lifecycle.State.CREATED)
    }

    override fun onStart() {
        super.onStart()
        registry.markState(Lifecycle.State.STARTED)
    }

    override fun onResume() {
        super.onResume()
        registry.markState(Lifecycle.State.RESUMED)
    }

    override fun onDestroy() {
        super.onDestroy()
        registry.markState(Lifecycle.State.DESTROYED)
    }

    override fun getLifecycle(): Lifecycle {
        return registry
    }


}