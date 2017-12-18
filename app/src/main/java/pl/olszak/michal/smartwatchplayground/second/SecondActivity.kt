package pl.olszak.michal.smartwatchplayground.second

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.activity_second.*
import pl.olszak.michal.smartwatchplayground.R

class SecondActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message : String? = intent.getStringExtra(EXTRA_MESSAGE)
        if(message != null){
            text.text = message
        }

        setAmbientEnabled()
    }

    companion object {
        private val EXTRA_MESSAGE = "second_extra_message"

        fun createIntent(context: Context, message: String) : Intent{
            val intent = Intent(context, SecondActivity::class.java)
            intent.apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            return intent
        }
    }
}
