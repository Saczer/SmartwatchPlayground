package pl.olszak.michal.smartwatchplayground.domain.interactor

import io.reactivex.Observable
import pl.olszak.michal.smartwatchplayground.data.location.LocationRepository
import pl.olszak.michal.smartwatchplayground.domain.interactor.ObservableUseCase
import pl.olszak.michal.smartwatchplayground.model.common.Location
import pl.olszak.michal.smartwatchplayground.rx.PlaygroundSchedulers
import javax.inject.Inject

/**
 * @author molszak
 *         created on 16.11.2017.
 */
class GetLocationUpdates @Inject constructor(
        private val repository: LocationRepository,
        schedulers: PlaygroundSchedulers) : ObservableUseCase<Location, Void?>(schedulers) {

    override fun buildUseCaseObservable(params: Void?): Observable<Location> = repository.getLocationStream()

}