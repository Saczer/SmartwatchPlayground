package pl.olszak.michal.smartwatchplayground.domain.interactor.hello

import io.reactivex.Single
import pl.olszak.michal.smartwatchplayground.data.hello.GreetingRepository
import pl.olszak.michal.smartwatchplayground.domain.interactor.SingleUseCase
import pl.olszak.michal.smartwatchplayground.rx.PlaygroundSchedulers
import javax.inject.Inject

/**
 * @author molszak
 *         created on 09.11.2017.
 */
class GreetingUseCase @Inject constructor(
        private val repository: GreetingRepository,
        schedulers: PlaygroundSchedulers) : SingleUseCase<String, Void?>(schedulers) {

    override fun buildUseCaseObservable(params: Void?): Single<String> = repository.getGreeting()

}