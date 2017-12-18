package pl.olszak.michal.smartwatchplayground.navigation

import android.content.Context
import android.content.Intent
import android.support.wearable.activity.ConfirmationActivity
import pl.olszak.michal.smartwatchplayground.second.SecondActivity
import javax.inject.Inject

/**
 * @author molszak
 *         created on 18.12.2017.
 */
class AndroidNavigator @Inject constructor(private val context: Context) : Navigator {

    override fun gotToSecond(message: String) {
        val intent = SecondActivity.createIntent(context, message)
        context.startActivity(intent)
    }

    override fun showConfirmation(message: String) {
        val intent = Intent(context, ConfirmationActivity::class.java)
        intent.apply {
            putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.SUCCESS_ANIMATION)
            putExtra(ConfirmationActivity.EXTRA_MESSAGE, message)
        }
        context.startActivity(intent)
    }
}