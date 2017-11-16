package pl.olszak.michal.smartwatchplayground.data

import io.reactivex.Observable
import pl.olszak.michal.smartwatchplayground.model.common.Location

/**
 * @author molszak
 *         created on 16.11.2017.
 */
interface LocationRepository {

    fun getLocationStream() : Observable<Location>

}