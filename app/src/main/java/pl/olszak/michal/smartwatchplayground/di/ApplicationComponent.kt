package pl.olszak.michal.smartwatchplayground.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import pl.olszak.michal.smartwatchplayground.SmartwatchPlayground
import pl.olszak.michal.smartwatchplayground.di.module.ActivityBindingModule
import pl.olszak.michal.smartwatchplayground.di.module.ApiModule
import pl.olszak.michal.smartwatchplayground.di.module.ApplicationModule
import pl.olszak.michal.smartwatchplayground.di.module.ServiceBindingModule
import pl.olszak.michal.smartwatchplayground.di.scope.PerApplication

/**
 * @author molszak
 *         created on 08.11.2017.
 */
@PerApplication
@Component(
        modules = arrayOf(
                ActivityBindingModule::class,
                ServiceBindingModule::class,
                ApplicationModule::class,
                ApiModule::class,
                AndroidSupportInjectionModule::class
        )
)
interface ApplicationComponent {

        @Component.Builder
        interface Builder {
                @BindsInstance fun application(application: Application): Builder
                fun build(): ApplicationComponent
        }

        fun inject(app: SmartwatchPlayground)

}