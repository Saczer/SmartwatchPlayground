package pl.olszak.michal.smartwatchplayground.welcome.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import kotlinx.android.synthetic.main.merge_welcome_view.view.*
import pl.olszak.michal.smartwatchplayground.R
import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.model.json.current.CurrentWeather

/**
 * @author molszak
 *         created on 15.12.2017.
 */
class WelcomeView(context: Context, attrs: AttributeSet?) : ScrollView(context, attrs), WelcomeDisplay {

    override fun showCurrentWeather(weather: CurrentWeather) {
        text.text = weather.toString()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        View.inflate(context, R.layout.merge_welcome_view, this)
    }

    override fun showGreeting(message: String) {
        text.text = message
    }

    override fun showLocation(location: Location) {
    }

    override fun showError() {
        Toast.makeText(context, "Error occured", Toast.LENGTH_LONG).show()
    }


    override fun attach(interactionListener: WelcomeDisplay.InteractionListener) {
        box_layout.setOnClickListener({
            interactionListener.onWindowClicked()
        })
    }

    override fun detach(interactionListener: WelcomeDisplay.InteractionListener) {

    }
}