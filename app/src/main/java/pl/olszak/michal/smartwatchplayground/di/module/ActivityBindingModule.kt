package pl.olszak.michal.smartwatchplayground.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.olszak.michal.smartwatchplayground.di.module.activity.MainActivityModule
import pl.olszak.michal.smartwatchplayground.di.module.activity.SecondActivityModule
import pl.olszak.michal.smartwatchplayground.di.scope.PerActivity
import pl.olszak.michal.smartwatchplayground.second.SecondActivity
import pl.olszak.michal.smartwatchplayground.welcome.WelcomeActivity

/**
 * @author molszak
 *         created on 08.11.2017.
 */
@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): WelcomeActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(SecondActivityModule::class))
    abstract fun bindSecondActivity(): SecondActivity


}