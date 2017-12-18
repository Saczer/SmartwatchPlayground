package pl.olszak.michal.smartwatchplayground.di.module.activity

import dagger.Module
import dagger.Provides
import pl.olszak.michal.smartwatchplayground.di.scope.PerActivity
import pl.olszak.michal.smartwatchplayground.second.SecondActivity

/**
 * @author molszak
 *         created on 18.12.2017.
 */
@Module
class SecondActivityModule {

    @Provides
    @PerActivity
    fun provideSecondActivity(secondActivity: SecondActivity) : SecondActivity = secondActivity
}