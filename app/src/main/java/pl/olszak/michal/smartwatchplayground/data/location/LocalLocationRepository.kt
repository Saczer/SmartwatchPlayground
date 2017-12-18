package pl.olszak.michal.smartwatchplayground.data.location

import android.content.SharedPreferences
import io.reactivex.Observable
import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.util.PlaygroundPreferences
import javax.inject.Inject

/**
 * @author molszak
 *         created on 16.11.2017.
 */
class LocalLocationRepository @Inject constructor(
        private val preferences: PlaygroundPreferences) : LocationRepository {

    private val observable : Observable<Location>

    init {
        observable = Observable.create({ emitter ->
            val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
                when(key){
                    PlaygroundPreferences.LONGITUDE_KEY,
                    PlaygroundPreferences.LATITUDE_KEY -> emitter.onNext(preferences.getLocation())
                }
            }

            emitter.setCancellable({
                preferences.uregisterOnSharedPreferencesChangeListener(listener)
            })

            preferences.registerOnSharedPreferencesChangeListener(listener)
        })
    }

    override fun getLocationStream(): Observable<Location> = observable

}