package pl.olszak.michal.smartwatchplayground.data.hello

import io.reactivex.Single
import javax.inject.Inject

/**
 * @author molszak
 *         created on 09.11.2017.
 */
class SimpleGreetingRepository @Inject constructor() : GreetingRepository {

    override fun getGreeting(): Single<String> {
        return Single.just("Hello world")
    }

}