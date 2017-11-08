package pl.olszak.michal.smartwatchplayground.di.module

import dagger.Module
import dagger.Provides
import pl.olszak.michal.smartwatchplayground.main.MainActivity
import pl.olszak.michal.smartwatchplayground.di.scope.PerActivity

/**
 * @author molszak
 *         created on 08.11.2017.
 */
@Module
class MainActivityModule {

    @Provides
    @PerActivity
    internal fun provideMianActivity(mainActivity : MainActivity): MainActivity {
        return mainActivity
    }


}