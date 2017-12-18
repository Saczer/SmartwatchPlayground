package pl.olszak.michal.smartwatchplayground.welcome.view

import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.model.json.current.CurrentWeather

/**
 * @author molszak
 *         created on 15.12.2017.
 */
interface WelcomeDisplay {

    fun attach(interactionListener: InteractionListener)

    fun detach(interactionListener: InteractionListener)

    fun showGreeting(message: String)

    fun showLocation(location: Location)

    fun showCurrentWeather(weather: CurrentWeather)

    fun showError()

    interface InteractionListener {

        fun onWindowClicked()
    }
}