package pl.olszak.michal.smartwatchplayground.domain.interactor

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import pl.olszak.michal.smartwatchplayground.rx.PlaygroundSchedulers

/**
 * @author molszak
 *         created on 09.11.2017.
 */
abstract class SingleUseCase<T, in Params> constructor(
        private val schedulers: PlaygroundSchedulers) {

    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

    open fun execute(singleObserver: DisposableSingleObserver<T>, params: Params? = null){
        val single = buildUseCaseObservable(params)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui()) as Single<T>

        addDisposable(single.subscribeWith(singleObserver))
    }

    fun dispose(){
        if(!disposables.isDisposed){
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable){
        disposables.add(disposable)
    }

}