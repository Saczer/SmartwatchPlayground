package pl.olszak.michal.smartwatchplayground

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import pl.olszak.michal.smartwatchplayground.di.ApplicationComponent
import pl.olszak.michal.smartwatchplayground.di.DaggerApplicationComponent
import timber.log.Timber
import javax.inject.Inject

/**
 * @author molszak
 *         created on 08.11.2017.
 */
class SmartwatchPlayground : Application(), HasActivityInjector {

    @Inject lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        val component : ApplicationComponent = DaggerApplicationComponent
                .builder()
                .application(this)
                .build()

        component.inject(this)

        plantTimber()
    }

    private fun plantTimber(){
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }


    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingInjector
    }
}