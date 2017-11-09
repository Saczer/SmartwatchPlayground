package pl.olszak.michal.smartwatchplayground.data.hello

import io.reactivex.Single

/**
 * @author molszak
 *         created on 09.11.2017.
 */
interface GreetingRepository {

    fun getGreeting(): Single<String>

}