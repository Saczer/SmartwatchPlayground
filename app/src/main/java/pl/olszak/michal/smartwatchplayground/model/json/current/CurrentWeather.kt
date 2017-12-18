package pl.olszak.michal.smartwatchplayground.model.json.current

/**
 * @author molszak
 *         created on 18.12.2017.
 */
data class CurrentWeather(val coord: Coordinates,
                          val weather: Array<Weather>,
                          val main: WeatherConditions,
                          val wind: Wind,
                          val rain: Rain?,
                          val snow: Snow?,
                          val dt: Long,
                          val sys: System,
                          val id: Int,
                          val name: String,
                          val visibility: Int)