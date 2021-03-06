package pl.olszak.michal.smartwatchplayground.di.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import pl.olszak.michal.smartwatchplayground.di.scope.PerApplication
import pl.olszak.michal.smartwatchplayground.navigation.AndroidNavigator
import pl.olszak.michal.smartwatchplayground.navigation.Navigator
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
    internal fun provideContext(application: Application): Context = application

    @Provides
    @PerApplication
    internal fun providePlaygroundSchedulers(schedulers: PlaygroundSchedulersFacade): PlaygroundSchedulers =
            schedulers

    @Provides
    @PerApplication
    internal fun provideSharedPreferences(context: Context) =
            PreferenceManager.getDefaultSharedPreferences(context)


    @Provides
    @PerApplication
    internal fun provideResources(context: Context): Resources = context.resources

    @Provides
    @PerApplication
    internal fun provideNavigator(androidNavigator: AndroidNavigator) : Navigator = androidNavigator


}