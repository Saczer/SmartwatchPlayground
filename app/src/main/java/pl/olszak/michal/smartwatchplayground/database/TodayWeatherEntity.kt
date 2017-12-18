package pl.olszak.michal.smartwatchplayground.database

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import pl.olszak.michal.smartwatchplayground.model.json.current.*

/**
 * @author molszak
 *         created on 18.12.2017.
 */
@Entity(tableName = "today_weather")
data class TodayWeatherEntity(@PrimaryKey val id: Long,
                              @Embedded val coord: Coordinates,
                              @Embedded val main: WeatherConditions,
                              @Embedded val wind: Wind,
                              @Embedded val rain: Rain?,
                              @Embedded val snow: Snow?,
                              val dt: Long,
                              @Embedded val sys: System,
                              val name: String,
                              val visibility: Int)