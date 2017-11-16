package pl.olszak.michal.smartwatchplayground.util.extension

/**
 * @author molszak
 *         created on 13.11.2017.
 */

object Doubles {

    fun toRawLongBits(value: Double): Long = java.lang.Double.doubleToRawLongBits(value)

    fun fromRawLongBits(value: Long): Double = java.lang.Double.longBitsToDouble(value)
}
