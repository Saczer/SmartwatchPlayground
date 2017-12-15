package pl.olszak.michal.smartwatchplayground.welcome.view

import android.content.Context
import android.support.wear.widget.BoxInsetLayout
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.merge_welcome_view.view.*
import pl.olszak.michal.smartwatchplayground.R
import pl.olszak.michal.smartwatchplayground.model.common.Location

/**
 * @author molszak
 *         created on 15.12.2017.
 */
class WelcomeView(context: Context, attrs: AttributeSet?) : BoxInsetLayout(context, attrs), WelcomeDisplay {

    override fun onFinishInflate() {
        super.onFinishInflate()
        View.inflate(context, R.layout.merge_welcome_view, this)
    }

    override fun showGreeting(message: String) {
        text.text = message
    }

    override fun showLocation(location: Location) {
    }

    override fun displayError() {
        Toast.makeText(context, "Error occured", Toast.LENGTH_LONG).show()
    }
}