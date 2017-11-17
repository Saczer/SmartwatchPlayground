package pl.olszak.michal.smartwatchplayground.di.module.service

import dagger.Module
import dagger.Provides
import pl.olszak.michal.smartwatchplayground.di.scope.PerService
import pl.olszak.michal.smartwatchplayground.service.PlaygroundLocationService

/**
 * @author molszak
 *         created on 17.11.2017.
 */
@Module
class PlaygroundLocationServiceModule {

    @Provides
    @PerService
    internal fun providePlaygroundLocationService(service: PlaygroundLocationService): PlaygroundLocationService =
            service
}