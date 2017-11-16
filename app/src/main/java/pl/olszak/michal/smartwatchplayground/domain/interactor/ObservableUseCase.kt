package pl.olszak.michal.smartwatchplayground.domain.interactor

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import pl.olszak.michal.smartwatchplayground.rx.PlaygroundSchedulers

/**
 * @author molszak
 *         created on 16.11.2017.
 */
abstract class ObservableUseCase<T, in Params> constructor(
        private val schedulers: PlaygroundSchedulers) {

    protected abstract fun buildUseCaseObservable(params: Params? = null): Observable<T>

    private val disposables: CompositeDisposable = CompositeDisposable()

    open fun execute(consumer: Consumer<T>, params : Params? = null) {
        val observable = buildUseCaseObservable(params)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())

        addDisposable(observable.subscribe(consumer))
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