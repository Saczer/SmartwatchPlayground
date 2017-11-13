package pl.olszak.michal.smartwatchplayground.util.extension

/**
 * @author molszak
 *         created on 13.11.2017.
 */

object DoubleExtension{
    fun toRawLongBits(value: Double) : Long {
        return java.lang.Double.doubleToRawLongBits(value)
    }

    fun fromRawLongBits(value: Long) : Double{
        return java.lang.Double.longBitsToDouble(value)
    }
}
