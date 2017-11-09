package pl.olszak.michal.smartwatchplayground.di.module

import dagger.Module
import dagger.Provides
import pl.olszak.michal.smartwatchplayground.data.hello.GreetingRepository
import pl.olszak.michal.smartwatchplayground.data.hello.SimpleGreetingRepository
import pl.olszak.michal.smartwatchplayground.main.MainActivity
import pl.olszak.michal.smartwatchplayground.di.scope.PerActivity
import pl.olszak.michal.smartwatchplayground.domain.interactor.hello.GreetingUseCase
import pl.olszak.michal.smartwatchplayground.main.MainActivityViewModel

/**
 * @author molszak
 *         created on 08.11.2017.
 */
@Module
class MainActivityModule {

    @Provides
    @PerActivity
    internal fun provideMainActivity(mainActivity : MainActivity): MainActivity {
        return mainActivity
    }

    @Provides
    @PerActivity
    internal fun provideRepository(greetingRepository: SimpleGreetingRepository) : GreetingRepository{
        return greetingRepository
    }

    @Provides
    @PerActivity
    internal fun provideViewModel(greetingUseCase: GreetingUseCase) : MainActivityViewModel{
        return MainActivityViewModel(greetingUseCase)
    }


}