package pl.olszak.michal.smartwatchplayground.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.olszak.michal.smartwatchplayground.di.scope.PerService
import pl.olszak.michal.smartwatchplayground.service.PlaygroundLocationService

/**
 * @author molszak
 *         created on 16.11.2017.
 */
@Module
abstract class ServiceBindingModule {

    @PerService
    @ContributesAndroidInjector
    abstract fun bindPlaygroundLocationService() : PlaygroundLocationService


}