package pl.olszak.michal.smartwatchplayground.data.weather

import io.reactivex.Single
import pl.olszak.michal.smartwatchplayground.model.json.current.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author molszak
 *         created on 18.12.2017.
 */
interface WeatherRepository {

    @GET("weather")
    fun getCurrentWeather(@Query("q") cityName: String): Single<CurrentWeather>

}