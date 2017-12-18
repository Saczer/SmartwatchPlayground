package pl.olszak.michal.smartwatchplayground.domain.interactor.weather

import io.reactivex.Single
import pl.olszak.michal.smartwatchplayground.data.weather.WeatherRepository
import pl.olszak.michal.smartwatchplayground.domain.interactor.SingleUseCase
import pl.olszak.michal.smartwatchplayground.model.json.current.CurrentWeather
import pl.olszak.michal.smartwatchplayground.rx.PlaygroundSchedulers
import javax.inject.Inject

/**
 * @author molszak
 *         created on 18.12.2017.
 */
class GetCurrentWeather @Inject constructor(
        private val repository: WeatherRepository,
        schedulers: PlaygroundSchedulers) : SingleUseCase<CurrentWeather, String>(schedulers) {

    override fun buildUseCaseObservable(params: String?): Single<CurrentWeather> {
        return repository.getCurrentWeather(params ?: "Żory")
    }

}