package pl.olszak.michal.smartwatchplayground.model.json.current

import com.squareup.moshi.Json

/**
 * @author molszak
 *         created on 18.12.2017.
 */
data class Snow(@Json(name = "3h") val volume : Float)