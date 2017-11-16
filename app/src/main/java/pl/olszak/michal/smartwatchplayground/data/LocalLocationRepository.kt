package pl.olszak.michal.smartwatchplayground.data

import android.content.SharedPreferences
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.util.PlaygroundPreferences
import javax.inject.Inject

/**
 * @author molszak
 *         created on 16.11.2017.
 */
class LocalLocationRepository @Inject constructor(
        private val preferences: PlaygroundPreferences) : LocationRepository, SharedPreferences.OnSharedPreferenceChangeListener {

    private val subject: PublishSubject<Location> = PublishSubject.create()

    init {
        preferences.registerOnSharedPreferencesChangeListener(this)
    }

    override fun getLocationStream(): Observable<Location> = subject

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        when(key){
            PlaygroundPreferences.LONGITUDE_KEY,
            PlaygroundPreferences.LATITUDE_KEY -> subject.onNext(preferences.getLocation())
        }
    }
}