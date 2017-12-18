package pl.olszak.michal.smartwatchplayground.di.module.activity

import dagger.Module
import dagger.Provides
import pl.olszak.michal.smartwatchplayground.data.location.LocalLocationRepository
import pl.olszak.michal.smartwatchplayground.data.location.LocationRepository
import pl.olszak.michal.smartwatchplayground.data.weather.WeatherRepository
import pl.olszak.michal.smartwatchplayground.di.scope.PerActivity
import pl.olszak.michal.smartwatchplayground.domain.interactor.GetLocationUpdates
import pl.olszak.michal.smartwatchplayground.domain.interactor.weather.GetCurrentWeather
import pl.olszak.michal.smartwatchplayground.navigation.Navigator
import pl.olszak.michal.smartwatchplayground.welcome.WelcomeActivity
import pl.olszak.michal.smartwatchplayground.welcome.presentation.WelcomeViewModel
import retrofit2.Retrofit

/**
 * @author molszak
 *         created on 08.11.2017.
 */
@Module
class MainActivityModule {

    @Provides
    @PerActivity
    internal fun provideMainActivity(welcomeActivity: WelcomeActivity): WelcomeActivity = welcomeActivity

    @Provides
    @PerActivity
    internal fun provideLocationRepository(locationRepository: LocalLocationRepository): LocationRepository =
            locationRepository

    @Provides
    @PerActivity
    internal fun provideWeatherRepository(retrofit: Retrofit): WeatherRepository {
        return retrofit.create(WeatherRepository::class.java)
    }

    @Provides
    @PerActivity
    internal fun provideViewModel(locationUseCase: GetLocationUpdates,
                                  getCurrentWeather: GetCurrentWeather,
                                  navigator: Navigator): WelcomeViewModel =
            WelcomeViewModel(locationUseCase, getCurrentWeather, navigator)


}