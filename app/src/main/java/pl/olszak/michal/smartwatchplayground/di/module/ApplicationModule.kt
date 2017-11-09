package pl.olszak.michal.smartwatchplayground.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import pl.olszak.michal.smartwatchplayground.di.scope.PerApplication
import pl.olszak.michal.smartwatchplayground.rx.PlaygroundSchedulers
import pl.olszak.michal.smartwatchplayground.rx.PlaygroundSchedulersFacade

/**
 * @author molszak
 *         created on 08.11.2017.
 */
@PerApplication
@Module
class ApplicationModule {

    @Provides
    @PerApplication
    internal fun provideContext(application: Application): Context{
        return application
    }

    @Provides
    @PerApplication
    internal fun providePlaygroundSchedulers(schedulers: PlaygroundSchedulersFacade) : PlaygroundSchedulers{
        return schedulers
    }

}