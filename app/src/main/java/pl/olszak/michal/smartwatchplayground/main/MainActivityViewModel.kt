package pl.olszak.michal.smartwatchplayground.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableSingleObserver
import pl.olszak.michal.smartwatchplayground.domain.interactor.hello.GreetingUseCase
import pl.olszak.michal.smartwatchplayground.domain.interactor.hello.LocationUseCase
import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.model.viewmodel.Response
import javax.inject.Inject

/**
 * @author molszak
 *         created on 09.11.2017.
 */
class MainActivityViewModel @Inject constructor(
        private val greetingUseCase: GreetingUseCase,
        private val locationUseCase: LocationUseCase) : ViewModel() {

    internal val greeting: MutableLiveData<Response<String>> = MutableLiveData()
    internal val location: MutableLiveData<Location> = MutableLiveData()

    internal fun startLocationUpdates() {
        locationUseCase.execute(Consumer { update ->
            location.value = update
        })
    }

    internal fun loadGreeting() {
        greetingUseCase.execute(singleObserver = object : DisposableSingleObserver<String>() {
            override fun onSuccess(string: String) {
                greeting.value = Response.success(string)
            }

            override fun onError(throwable: Throwable) {
                greeting.value = Response.error(throwable)
            }

        })
    }

    override fun onCleared() {
        greetingUseCase.dispose()
        locationUseCase.dispose()
    }

}