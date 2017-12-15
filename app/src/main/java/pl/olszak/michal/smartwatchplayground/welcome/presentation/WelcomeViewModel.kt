package pl.olszak.michal.smartwatchplayground.welcome.presentation

import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import pl.olszak.michal.smartwatchplayground.domain.ViewModel
import pl.olszak.michal.smartwatchplayground.domain.interactor.hello.GetGreeting
import pl.olszak.michal.smartwatchplayground.domain.interactor.hello.GetLocationUpdates
import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.welcome.view.WelcomeDisplay
import javax.inject.Inject

/**
 * @author molszak
 *         created on 09.11.2017.
 */
class WelcomeViewModel @Inject constructor(
        private val greeting: GetGreeting,
        private val location: GetLocationUpdates) : ViewModel {

    var display : WelcomeDisplay? = null

    internal fun startLocationUpdates() {
        location.execute(observer = object : DisposableObserver<Location>(){
            override fun onComplete() {
            }

            override fun onNext(location: Location) {
                display?.showLocation(location)
            }

            override fun onError(e: Throwable) {
                display?.displayError()
            }

        })
    }

    internal fun loadGreeting() {
        greeting.execute(singleObserver = object : DisposableSingleObserver<String>() {
            override fun onSuccess(string: String) {
                 display?.showGreeting(string)
            }

            override fun onError(throwable: Throwable) {
                display?.displayError()
            }

        })
    }

    override fun dispose() {
        location.dispose()
        greeting.dispose()
    }

}