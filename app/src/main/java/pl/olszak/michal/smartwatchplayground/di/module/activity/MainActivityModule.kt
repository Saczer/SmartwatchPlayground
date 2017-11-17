package pl.olszak.michal.smartwatchplayground.di.module.activity

import dagger.Module
import dagger.Provides
import pl.olszak.michal.smartwatchplayground.data.LocalLocationRepository
import pl.olszak.michal.smartwatchplayground.data.LocationRepository
import pl.olszak.michal.smartwatchplayground.data.hello.GreetingRepository
import pl.olszak.michal.smartwatchplayground.data.hello.SimpleGreetingRepository
import pl.olszak.michal.smartwatchplayground.di.scope.PerActivity
import pl.olszak.michal.smartwatchplayground.domain.interactor.hello.GreetingUseCase
import pl.olszak.michal.smartwatchplayground.domain.interactor.hello.LocationUseCase
import pl.olszak.michal.smartwatchplayground.main.MainActivity
import pl.olszak.michal.smartwatchplayground.main.MainActivityViewModel

/**
 * @author molszak
 *         created on 08.11.2017.
 */
@Module
class MainActivityModule {

    @Provides
    @PerActivity
    internal fun provideMainActivity(mainActivity: MainActivity): MainActivity = mainActivity

    @Provides
    @PerActivity
    internal fun provideRepository(greetingRepository: SimpleGreetingRepository): GreetingRepository =
            greetingRepository

    @Provides
    @PerActivity
    internal fun provideLocationRepository(locationRepository: LocalLocationRepository) : LocationRepository =
            locationRepository

    @Provides
    @PerActivity
    internal fun provideViewModel(greetingUseCase: GreetingUseCase,
                                  locationUseCase: LocationUseCase): MainActivityViewModel =
            MainActivityViewModel(greetingUseCase, locationUseCase)


}