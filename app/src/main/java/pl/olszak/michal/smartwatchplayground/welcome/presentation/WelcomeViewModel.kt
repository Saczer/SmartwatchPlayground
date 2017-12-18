package pl.olszak.michal.smartwatchplayground.welcome.presentation

import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import pl.olszak.michal.smartwatchplayground.domain.ViewModel
import pl.olszak.michal.smartwatchplayground.domain.interactor.weather.GetCurrentWeather
import pl.olszak.michal.smartwatchplayground.domain.interactor.GetLocationUpdates
import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.model.json.current.CurrentWeather
import pl.olszak.michal.smartwatchplayground.navigation.Navigator
import pl.olszak.michal.smartwatchplayground.welcome.view.WelcomeDisplay

/**
 * @author molszak
 *         created on 09.11.2017.
 */
class WelcomeViewModel constructor(
        private val location: GetLocationUpdates,
        private val weather: GetCurrentWeather,
        private val navigator: Navigator) : ViewModel {

    var display: WelcomeDisplay? = null
        set(display) {
            if (display != null) {
                field = display
                display.attach(listener)
            }
        }

    private val listener = object : WelcomeDisplay.InteractionListener {

        override fun onWindowClicked() {
            navigator.gotToSecond("Hey there")
        }
    }

    fun startLocationUpdates() {
        location.execute(observer = object : DisposableObserver<Location>() {
            override fun onComplete() {
            }

            override fun onNext(location: Location) {
                display?.showLocation(location)
            }

            override fun onError(e: Throwable) {
                display?.showError()
            }

        })
    }

    fun loadCurrentWeather() {
        weather.execute(singleObserver = object : DisposableSingleObserver<CurrentWeather>() {
            override fun onSuccess(currentWeather: CurrentWeather) {
                navigator.showConfirmation("Some message")
                display?.showCurrentWeather(currentWeather)
            }

            override fun onError(e: Throwable) {
                display?.showError()
            }

        })
    }

    override fun dispose() {
        display?.detach(listener)
        location.dispose()
    }

}