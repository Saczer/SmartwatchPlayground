package pl.olszak.michal.smartwatchplayground.welcome.view

import pl.olszak.michal.smartwatchplayground.model.common.Location

/**
 * @author molszak
 *         created on 15.12.2017.
 */
interface WelcomeDisplay {

    fun showGreeting(message: String)

    fun showLocation(location: Location)

    fun displayError()
}